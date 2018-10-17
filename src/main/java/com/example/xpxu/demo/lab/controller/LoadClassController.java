package com.example.xpxu.demo.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xupeng.
 */
@RestController
public class LoadClassController {

    @GetMapping("/loader")
    public String getLoader(){
        StringBuffer sb = new StringBuffer();
        ClassLoader loader = this.getClass().getClassLoader();
        while(loader != null) {
            sb.append(loader.getClass().getName()+"<br/>");
            loader = loader.getParent();
        }
        return sb.toString();
    }

}
