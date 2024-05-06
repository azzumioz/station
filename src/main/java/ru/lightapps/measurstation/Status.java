package ru.lightapps.measurstation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Status {
    @JsonSerialize
    private String status;

    public Status(String status) {
        this.status = status;
    }

}
