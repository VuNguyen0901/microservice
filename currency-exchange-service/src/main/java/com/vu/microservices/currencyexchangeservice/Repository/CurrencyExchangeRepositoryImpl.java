package com.vu.microservices.currencyexchangeservice.Repository;

import com.vu.microservices.currencyexchangeservice.Entity.CurrencyExchangeEntity;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Primary
public class CurrencyExchangeRepositoryImpl implements CurrencyExchangeRepository{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection


    @Autowired
    public CurrencyExchangeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public CurrencyExchangeEntity add(CurrencyExchangeEntity currencyExchangeEntity) {
        entityManager.merge(currencyExchangeEntity);
        return currencyExchangeEntity;
    }

    @Override
    public CurrencyExchangeEntity findById(int id) {

        return entityManager.find(CurrencyExchangeEntity.class, id);
    }

    @Override
    public List<CurrencyExchangeEntity> findAll() {
        return null;
    }

    @Override
    public CurrencyExchangeEntity update(CurrencyExchangeEntity currencyExchangeEntity) {
        return null;
    }

    @Override
    public CurrencyExchangeEntity deleteById(int id) {
        return null;
    }

    @Override
    public CurrencyExchangeEntity findCurrencyFromTo(String from, String to){
        TypedQuery<CurrencyExchangeEntity> theQuery = entityManager.createQuery("From CurrencyExchangeEntity where sourceCurrency=:from AND destinationCurrency=:to", CurrencyExchangeEntity.class);
        theQuery.setParameter("from",from);
        theQuery.setParameter("to",to);
        return theQuery.getSingleResult();
    }
}
