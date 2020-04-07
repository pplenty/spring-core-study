package com.jason.springcorestudy.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2020/02/22.
 */
@RestController
public class DumpController {


    @RequestMapping("/dump/index")
    public String index() {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add(new Data(i, "test" + i));
        }
        return list.get(0).toString();
    }

    @AllArgsConstructor
    private static class Data {
        private int num;
        private String name;
    }
}
