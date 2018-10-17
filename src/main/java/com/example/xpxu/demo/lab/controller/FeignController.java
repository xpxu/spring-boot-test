package com.example.xpxu.demo.lab.controller;

import com.example.xpxu.demo.lab.service.DemoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DATE 2018/9/24.
 * @author xupeng.
 */

@RestController
public class FeignController {

    @Autowired
    DemoFeignClient demoFeignClient;

    @GetMapping("/demo")
    public String run(){
        return demoFeignClient.hello();
    }
}
