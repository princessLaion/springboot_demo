package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.model.HelloBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

    @GetMapping(path = "/hello/{msg}")
    public HelloBean helloMessage(@PathVariable String msg) {
        return new HelloBean(msg);
    }

    @GetMapping(path = "/helloWorldL18n")
    public String helloMessageL18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(
                "good.morning",
                null,
                "Default message",
                locale
        );
    }

}
