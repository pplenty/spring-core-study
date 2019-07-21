package com.jason.springcorestudy.controller;

import com.jason.springcorestudy.service.IndexService;
import com.jason.springcorestudy.supports.KeywordValidator;
import com.jason.springcorestudy.supports.IndexParameters;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

/**
 * @author : yusik
 * @date : 2019-03-12
 */
@RestController
public class IndexController {

    private final IndexService indexService;
    private final KeywordValidator keywordValidator;

    public IndexController(IndexService indexService, KeywordValidator keywordValidator) {
        this.indexService = indexService;
        this.keywordValidator = keywordValidator;
    }


    @InitBinder
    private void initBinder(WebDataBinder dataBinder){
        dataBinder.setValidator(keywordValidator);
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

    @GetMapping("/test")
    Map test(@Validated String keyword, @Valid IndexParameters param) {

        System.out.println(param);
        Map<String, Object> result = new HashMap<>();

        Test test = new Test();
        test.no = 1;
        test.isNo = false;

        result.put("end", test);
        return result;
    }

    public class Test {
        String name;
        int no;

        boolean isNo;

        public String getName() {
            return name;
        }

        public int getNo() {
            return no;
        }

        public boolean isNo() {
            return isNo;
        }
    }

    @GetMapping("/enumTest")
    Map enumTest(Type type) {
        Map<String, Object> result = new HashMap<>();

        result.put("type", type);
        result.put("get", Type.A_TYPE);
        result.put("string", Type.A_TYPE.getName());

        return result;
    }

    public enum Type {

        A_TYPE("aType"),
        B_TYPE("b");

        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Type get(String name) {
            return Stream.of(values()).filter(type -> type.getName().equals(name)).findAny().orElse(null);
        }
    }
}
