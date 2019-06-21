package com.jason.springcorestudy.controller;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author : yusik
 * @date : 2019-03-12
 */
@RequestMapping("/es")
@RestController
public class EsController {

    @GetMapping("/index")
    String index() throws UnknownHostException {

        Client client = new PreBuiltTransportClient(
                Settings.builder().put("client.transport.sniff", true)
                        .put("cluster.name","elasticsearch").build())
                .addTransportAddress(
                        new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return null;
    }
}
