package com.microservices.currencyexchangeservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrenyRepository extends JpaRepository<CurrencyExchange,Long> {

     CurrencyExchange findByFromAndTo(String from, String to);
}
