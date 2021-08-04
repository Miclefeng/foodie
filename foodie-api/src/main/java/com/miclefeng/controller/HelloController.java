package com.miclefeng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miclefengzss
 * 2021/8/4 上午9:50
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "hello ~";
    }
}
