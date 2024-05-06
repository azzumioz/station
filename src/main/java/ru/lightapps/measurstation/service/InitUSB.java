package ru.lightapps.measurstation.service;

import org.springframework.stereotype.Component;

@Component
public class InitUSB {

    HT2000UsbConnection getConnection() throws Exception {
        return new HT2000UsbConnection();
    }

}
