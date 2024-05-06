package ru.lightapps.measurstation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public class Measure {
    private double temperature;
    private int co2;
    private double humidity;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    public Measure(double temperature, int co2, double humidity, LocalDateTime dateTime) {
        this.temperature = temperature;
        this.co2 = co2;
        this.humidity = humidity;
        this.dateTime = dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "temperature=" + temperature +
                ", co2=" + co2 +
                ", humidity=" + humidity +
                ", dateTime=" + dateTime +
                '}';
    }


}
