package com.hrf.spring.cloud.ribbon.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbonDemo")
public class RibbonDemoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/testRibbon")
    public String testRibbon() {
        return restTemplate.getForObject("http://nacos-demo/nacosDemo/test", String.class);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
