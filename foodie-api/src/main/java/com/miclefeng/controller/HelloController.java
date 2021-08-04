package com.miclefeng.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miclefengzss
 * 2021/8/4 下午5:49
 */

@RestController
public class HelloController {

    @PostMapping("/hello")
    public Object hello(String name) {
        return "hello world, " + name;
    }
}
