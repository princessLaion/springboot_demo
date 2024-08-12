package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.model.HelloBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping(path = "/hello/{msg}")
    public HelloBean helloMessage(@PathVariable String msg) {
        return new HelloBean(msg);
    }

}
