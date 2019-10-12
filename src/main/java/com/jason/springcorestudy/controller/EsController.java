package com.jason.springcorestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * @author : yusik
 * @date : 2019-03-12
 */

@Slf4j
@RequestMapping("/es")
@RestController
public class EsController {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @GetMapping("/index")
    String index() throws UnknownHostException {

        Client client = new PreBuiltTransportClient(
                Settings.builder().put("client.transport.sniff", true)
                        .put("cluster.name", "elasticsearch").build())
                .addTransportAddress(
                        new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return client.toString();
    }

    @GetMapping("/dateQuery")
    public String dateQuery(
            @RequestParam("startDate") @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime endDate) {

        return getQuery(startDate, endDate);
    }

    public String getQuery(LocalDateTime startDate, LocalDateTime endDate) {
        return "{\"size\": 0, \"query\":"
                + new NativeSearchQueryBuilder()
                .withQuery(boolQuery()
                        .must(termQuery("data.deployPhase.keyword", "dev"))
                        .must(rangeQuery("reqDate")
                                .timeZone("Asia/Seoul")
                                .gte(startDate.atOffset(ZoneOffset.ofHours(9)))
                                .lte(endDate.atZone(ZoneId.of("Asia/Seoul")).toOffsetDateTime())))
                .build().getQuery().toString() + "}";
    }

    @GetMapping("/rangeQuery")
    public String rangeQueryTest() {

        DateTimeFormatter defaultDatePrinter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
        log.debug(defaultDatePrinter.print(new Date().getTime()));

        final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
        final java.time.format.DateTimeFormatter DATE_TIME_FORMATTER = java.time.format.DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

        System.out.println(LocalDateTime.now().format(DATE_TIME_FORMATTER));

        log.debug(LocalDateTime.now().format(java.time.format.DateTimeFormatter.ISO_DATE_TIME));
        log.debug(LocalDateTime.now().format(java.time.format.DateTimeFormatter.ISO_DATE));
        log.debug(LocalDateTime.now().format(java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE));
        log.debug(LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        RangeQueryBuilder query = rangeQuery("reqDate")
                .timeZone(ZoneId.systemDefault().getId())
                .gte(LocalDateTime.now().atOffset(ZoneOffset.ofHours(9)))
                .lte(LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul")).toOffsetDateTime());

        log.debug("{}", query);
        return query.toString(true);
    }
}
