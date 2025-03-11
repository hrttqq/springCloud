package com.hrf.spring.cloud.nacos.demo.service.impl;

import com.hrf.spring.cloud.nacos.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String testDemo() {
        return "Nacos Test Demo Success!";
    }
}
