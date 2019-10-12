package com.jason.springcorestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : yusik
 * @date : 2019-08-15
 */
@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String main() {
        return "redirect:/";
    }
}
