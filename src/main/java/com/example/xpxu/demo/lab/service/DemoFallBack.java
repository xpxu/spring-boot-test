package com.example.xpxu.demo.lab.service;

import org.springframework.stereotype.Component;

/**
 * DATE 2018/9/29.
 * @author xupeng.
 */
@Component
public class DemoFallBack implements DemoFeignClient {

    @Override
    public String hello() {
        return "fallback";
    }
}
