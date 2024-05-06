package ru.lightapps.measurstation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lightapps.measurstation.Measure;
import ru.lightapps.measurstation.Status;
import ru.lightapps.measurstation.util.exception.NotConnectionException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class MeasureService {
    public static AtomicBoolean status = new AtomicBoolean(false);

    @Autowired
    InitUSB initUSB;

    public Measure getMeasure() {
        try {
            HT2000UsbConnection usbConnection = initUSB.getConnection();
            usbConnection.open();
            HT2000State state = usbConnection.readState();
            Measure measure = new Measure(state.getTemperature(), state.getCo2(), state.getHumidity(), LocalDateTime.now());
            usbConnection.close();
            status.set(true);
            return measure;
        } catch (Exception e) {
            status.set(false);
        }
        throw new NotConnectionException("Not connect to HT2000");
    }

    public Measure getFakeMeasure() {
        int temp = 20 + (int) (Math.random() * 25);
        int co2 = 1000 + (int) (Math.random() * 1200);
        int hum = 40 + (int) (Math.random() * 55);
        return new Measure(temp, co2, hum, LocalDateTime.now(ZoneId.of("Asia/Novosibirsk")));
    }

    public Status getStatus() {
        return new Status(status.toString());

    }

}
