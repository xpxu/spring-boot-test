package com.example.xpxu.demo.lab.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DATE 2018/9/27.
 * @author xupeng.
 */

@FeignClient(name = "wolf", fallback = DemoFallBack.class)
public interface DemoFeignClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
