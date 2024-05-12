# Measure station

### Publish data from HT2000 CO2, temperature, humidity to message broker.
##### Use module connection to HT2000 from project by Eugene Schava https://github.com/eschava/HT2000-java

### Tech stack
- JDK 8+;
- Maven;
- Spring boot;
- Rabbit MQ;

### Configuration File

Set properties in application.properties: 
- RabbitMQ Server properties
- AMQP properties
- Scheduler properties

### Service API

- GET /api/status - Get station status
- GET /api/measure - Get current measure


### Project architecture
![project_weather](https://github.com/azzumioz/station/assets/40742197/0ef5687f-7020-4e8c-b5b5-8e1d0fce341e)
