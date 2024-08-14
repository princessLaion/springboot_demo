package com.lrp.springboot.learn_spring_boot.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greet/v2")
public class GreetingsV2Controller {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World V2";
    }

}
