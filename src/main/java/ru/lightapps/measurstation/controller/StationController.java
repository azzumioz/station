package ru.lightapps.measurstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lightapps.measurstation.Measure;
import ru.lightapps.measurstation.Status;
import ru.lightapps.measurstation.service.MeasureService;


@RestController
public class StationController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MeasureService measureService;

    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<Status> getMessage() {
        logger.info("get status");
        return new ResponseEntity<>(measureService.getStatus(), HttpStatus.OK);
    }

    @GetMapping("/measure")
    @ResponseBody
    public Measure getMeasure() {
        logger.info("get real measure");
//        return measureService.getMeasure();
        Measure measure = measureService.getMeasure();
        return measure;
    }

    @GetMapping("/fake")
    @ResponseBody
    public Measure getFakeMeasure() {
        logger.info("get fake measure");
        return measureService.getFakeMeasure();
    }


}
