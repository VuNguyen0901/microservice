package com.vu.microservices.currencyexchangeservice.Entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "CurrencyExchange")
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Source_Currency")
    private String sourceCurrency;

    @Column(name = "Destination_Currency ")
    private String destinationCurrency;

    @Column(name = "Conversion_Multiple")
    private double conversionMultiple;

    @Column(name = "Environment")
    private String environment;


}
