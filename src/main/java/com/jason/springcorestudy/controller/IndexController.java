package com.jason.springcorestudy.controller;

import com.jason.springcorestudy.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author : yusik
 * @date : 2019-03-12
 */
@RestController
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/")
    String index() throws ExecutionException, InterruptedException {

        ListenableFuture<String> future = indexService.service();
//        String result = future.get();
        String result = "future";

        return result;
    }

    @GetMapping("/callable")
    Callable<String> callable() {

        return () -> "callable";
    }
}
