package com.vu.microservices.currencyexchangeservice.Controller;

import com.vu.microservices.currencyexchangeservice.Entity.CurrencyExchangeEntity;
import com.vu.microservices.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrencyExchangeController {

    private CurrencyExchangeRepository CurrencyExchange;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeRepository currencyExchange) {
        CurrencyExchange = currencyExchange;
    }

    @Autowired
    private Environment environment;
    @PostMapping("/CurrencyExchange")
    public CurrencyExchangeEntity addCurrencyExchanges(@RequestBody CurrencyExchangeEntity currencyExchange){

        return CurrencyExchange.add(currencyExchange);
    }

    @GetMapping("/CurrencyExchange/{CurrencyExchangeId}")
    public CurrencyExchangeEntity getCurrencyExchangesById(@PathVariable int CurrencyExchangeId){
        return CurrencyExchange.findById(CurrencyExchangeId);
    }

    @GetMapping("/CurrencyExchange/from/{from}/to/{to}")
    public CurrencyExchangeEntity getCurrencyExchangeFromTo(@PathVariable String from, @PathVariable String to){
        String port = environment.getProperty("local.server.port");
        CurrencyExchangeEntity result = CurrencyExchange.findCurrencyFromTo(from,to);
        result.setEnvironment(port);
        return result;
    }
}
