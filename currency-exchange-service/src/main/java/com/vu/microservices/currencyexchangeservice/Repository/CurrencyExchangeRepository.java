package com.vu.microservices.currencyexchangeservice.Repository;

import com.vu.microservices.currencyexchangeservice.Entity.CurrencyExchangeEntity;


import java.util.List;


public interface CurrencyExchangeRepository {

    CurrencyExchangeEntity add(CurrencyExchangeEntity currencyExchangeEntity);
    CurrencyExchangeEntity findById(int id);
    List<CurrencyExchangeEntity> findAll();
    CurrencyExchangeEntity update(CurrencyExchangeEntity currencyExchangeEntity);
    CurrencyExchangeEntity deleteById(int id);
    CurrencyExchangeEntity findCurrencyFromTo(String from, String to);

}
