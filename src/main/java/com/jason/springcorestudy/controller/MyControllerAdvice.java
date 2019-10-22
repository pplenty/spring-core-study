package com.jason.springcorestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : yusik
 * @date : 04/10/2019
 */
@Slf4j
//@EnableWebMvc
@ControllerAdvice
public class MyControllerAdvice {

    public MyControllerAdvice() {
        log.error("MyControllerAdvice..");
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity testError(Throwable e) {
        log.debug("########### error",e);
        return ResponseEntity
                .badRequest()
                .build();
    }
}
