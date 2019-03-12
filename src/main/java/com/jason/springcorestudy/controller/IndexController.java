package com.jason.springcorestudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yusik
 * @date : 2019-03-12
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "hello";
    }
}
