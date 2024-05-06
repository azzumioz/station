package ru.lightapps.measurstation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.lightapps.measurstation.Measure;
import ru.lightapps.measurstation.util.exception.NotConnectionException;

@EnableScheduling
@Component
public class ScheduledQueueMeasure {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    MeasureService measureService;

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Scheduled(initialDelayString = "${scheduler.initialDelayString}", fixedDelayString = "${scheduler.fixedDelayString}")
    public void sendMeasure() {
        try {
            sendMessage(measureService.getFakeMeasure());
        } catch (NotConnectionException ex) {
            log.error(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(Measure measure) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        try {
            rabbitTemplate.convertAndSend(queueName, measure);
            log.info("save message" + measure);
        } catch (AmqpConnectException ex) {
            log.error("Connection refused");
        }
    }


}
