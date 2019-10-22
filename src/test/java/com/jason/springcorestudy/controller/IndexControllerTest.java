package com.jason.springcorestudy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

	@Rank
	public void contextLoads() throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();

		String res = es.submit(() -> "Hello Async").get();

		System.out.println(res);

	}

}
