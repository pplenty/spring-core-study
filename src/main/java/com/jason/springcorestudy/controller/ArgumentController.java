package com.jason.springcorestudy.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kohyusik on 29/10/2019.
 */
@Slf4j
@RestController
public class ArgumentController {

    @GetMapping("/arg/datetime")
    public String dateTimeFormatTest(RequestDto requestModel) {
        log.debug("{}", requestModel);
        return "requestModel";
    }

    @Data
    private static class RequestDto {

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dateTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate date;
    }
}
