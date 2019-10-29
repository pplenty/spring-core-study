package com.jason.springcorestudy.controller;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kohyusik on 29/10/2019.
 */
@RestController
public class ArgumentController {
    @GetMapping("/arg/datetime")
    public String dateTimeFormatTest(RequestModel requestModel) {
        System.out.println(requestModel);
        return "requestModel";
    }

    @Data
    private static class RequestModel {

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dateTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate date;
    }
}
