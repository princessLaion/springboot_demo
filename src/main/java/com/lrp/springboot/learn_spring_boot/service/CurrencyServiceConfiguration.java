package com.lrp.springboot.learn_spring_boot.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "currency-service")
@Getter
@Setter
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;
}
