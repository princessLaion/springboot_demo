package com.lrp.springboot.learn_spring_boot.controller;

import com.lrp.springboot.learn_spring_boot.service.CurrencyServiceConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyConfigurationController {

    private final CurrencyServiceConfiguration currencyConfig;

    @RequestMapping("/currency-config")
    public CurrencyServiceConfiguration retrieveCurrencyConfig() {
        return currencyConfig;
    }

}
