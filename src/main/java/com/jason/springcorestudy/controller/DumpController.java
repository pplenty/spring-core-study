package com.jason.springcorestudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2020/02/22.
 */
@RestController
public class DumpController implements ApplicationContextAware {

    @Autowired
    ObjectMapper prototypeMapper;

    public DumpController() {

        System.out.println(prototypeMapper);
    }

    private ApplicationContext context;

    @RequestMapping("/dump/index")
    public String index() {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add(new Data(i, "test" + i));
        }
        return list.get(0).toString();
    }

    @GetMapping("/dump/context")
    public String context(String scope) {
        if ("prototype".equals(scope)) {
            System.out.println(context.getBean("prototypeMapper"));
        } else {
            System.out.println(context.getBean("singleMapper"));
        }

        return "ok";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @AllArgsConstructor
    private static class Data {
        private int num;
        private String name;
    }
}
