package com.jason.springcorestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kohyusik on 06/11/2019.
 */
@ControllerAdvice(annotations = RestController.class)
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AdviceController {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected Map<String, String> handleException(Exception ex) {
        Map<String, String> map = new HashMap<>();
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        map.put("message", ex.getMessage());
        map.put("ex", ex.getClass().getName());
        return map;
    }
}
