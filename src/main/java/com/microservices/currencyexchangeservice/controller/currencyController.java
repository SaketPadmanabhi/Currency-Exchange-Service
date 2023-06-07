package com.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class currencyController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrenyRepository currenyRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retreiveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange = currenyRepository.findByFromAndTo(from,to);
       if(currencyExchange == null){
            throw new RuntimeException("Unable to find data") ;
       }
       else{
           String port = environment.getProperty("local.server.port");
           currencyExchange.setEnvironment(port);
           return currencyExchange;
       }

    }

}
