package com.hrf.spring.cloud.nacos.demo.controller;

import com.hrf.spring.cloud.nacos.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacosDemo")
public class NacosDemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        return demoService.testDemo();
    }

    @RequestMapping("/getConfigText")
    public String getConfigText() {
        return demoService.getConfigText();
    }
}
