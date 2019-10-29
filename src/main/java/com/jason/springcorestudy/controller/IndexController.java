package com.jason.springcorestudy.controller;

import com.jason.springcorestudy.service.IndexService;
import com.jason.springcorestudy.supports.KeywordValidator;
import com.jason.springcorestudy.supports.IndexParameters;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.catalina.session.StandardSession;
import org.springframework.http.HttpMethod;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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

//    private final IndexService indexService;
//    private final KeywordValidator keywordValidator;
//
//    public IndexController(IndexService indexService, KeywordValidator keywordValidator) {
//        this.indexService = indexService;
//        this.keywordValidator = keywordValidator;
//    }


//    @InitBinder
//    private void initBinder(WebDataBinder dataBinder){
//        dataBinder.setValidator(keywordValidator);
//    }

    @RequestMapping(value = {"/test/1", "/test/2", "/test/3"}, method = {RequestMethod.POST, RequestMethod.GET})
    String testIndex(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ExecutionException, InterruptedException {
        String result = "future";

        return result;
    }

    @GetMapping("/testError")
    String error() {
        String result = "future";
        if (result.equals("future")) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @RequestMapping(value = {"/testArgs/{id}"}, method = {RequestMethod.POST, RequestMethod.GET})
    long testArgs(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                    @PathVariable long id, String var1, int var2, Integer var3) {
        System.out.println(id);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);

        return id;
    }

    @GetMapping("/")
    String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ExecutionException, InterruptedException {

        while (session.getAttributeNames().hasMoreElements()) {
            String name = session.getAttributeNames().nextElement();
        }

        String result = "future";
        System.out.println(response);
        Cookie cookie1 = new Cookie("test1", "1");
        Cookie cookie2 = new Cookie("test2", "2");
        Cookie cookie3 = new Cookie("test3", "3");
        cookie3.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addHeader("test", "1");

        return result;
    }

    @GetMapping("/callable")
    Callable<String> callable() {

        return () -> "callable";
    }

    @PostMapping("/test99")
    public String test99(Sample sample, Map<String, Object> map, String test, String test2, String name) {
        System.out.println(sample);
        System.out.println(map);
        System.out.println(name);
        return "test";
    }

    @Getter
    @Setter
    @ToString
    public class Sample {
        String id;
        String password;
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
