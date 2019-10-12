package com.jason.springcorestudy.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author : yusik
 * @date : 2019-03-12
 */
@Service
public class IndexService implements InitializingBean {

    @Async
    public ListenableFuture<String> service() {

        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("service finish");

        return new AsyncResult<>("result");
    }

    public ListenableFuture<String> service2() {

        try {
            Thread.sleep(3 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<>("result");
    }

    @Transactional
    public String transaction() {
        return "tx";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@");
        System.out.println();
    }
}
