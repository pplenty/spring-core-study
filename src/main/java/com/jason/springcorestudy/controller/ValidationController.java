package com.jason.springcorestudy.controller;

import com.jason.springcorestudy.validator.CustomConstraint;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kohyusik on 06/11/2019.
 */
@Slf4j
@RequestMapping("/valid")
@RestController
public class ValidationController {

    // http://localhost:8000/valid/test?names=1,2
    @GetMapping("/test")
    public RequestDto valid(@Valid RequestDto requestModel) {
        log.debug("{}", requestModel);
        return requestModel;
    }

    @Data
    @CustomConstraint(message = "필수!")
    public static class RequestDto {

        @NotEmpty
        private List<String> names;

        private List<String> ids;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dateTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate date;
    }
}
