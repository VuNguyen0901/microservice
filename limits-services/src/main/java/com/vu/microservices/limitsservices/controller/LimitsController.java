package com.vu.microservices.limitsservices.controller;

import com.vu.microservices.limitsservices.bean.Limits;
import com.vu.microservices.limitsservices.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public Limits retrievelLimits(){

        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
