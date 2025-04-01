package com.hrf.spring.cloud.sentinel.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinelDemo")
public class SentinelDemoController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @SentinelResource(value = "test", blockHandler = "handleBlocked")
    public String test() {
        return "test success!";
    }

    public String handleBlocked(BlockException e) {
        return "blocked!";
    }
}
