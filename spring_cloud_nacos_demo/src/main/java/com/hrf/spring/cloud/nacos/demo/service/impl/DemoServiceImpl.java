package com.hrf.spring.cloud.nacos.demo.service.impl;

import com.hrf.spring.cloud.nacos.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Value("${nacos.config.text}")
    private String text;

    @Override
    public String testDemo() {
        return "Nacos Test Demo Success!";
    }

    @Override
    public String getConfigText() {
        return text;
    }
}
