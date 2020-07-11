package com.demo.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class HttpUtil {

    private static RestTemplate restTemplate;

    @Qualifier("normalRestTemplate")
    @Resource
    private RestTemplate normalRestTemplateInit;


    @PostConstruct
    public void init() {
        restTemplate = normalRestTemplateInit;
    }

    public static RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
