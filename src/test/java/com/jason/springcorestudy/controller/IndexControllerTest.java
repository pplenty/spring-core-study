package com.jason.springcorestudy.controller;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class IndexControllerTest {

	public void contextLoads() throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();

		String res = es.submit(() -> "Hello Async").get();

		System.out.println(res);

	}

}
