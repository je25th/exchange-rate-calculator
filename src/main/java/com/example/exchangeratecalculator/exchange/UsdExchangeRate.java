package com.example.exchangeratecalculator.exchange;

import lombok.Getter;

import java.util.Map;

@Getter
public class UsdExchangeRate {
    private String timestamp;
    private Map<String, Float> quotes;

    public UsdExchangeRate() {
    }

    public UsdExchangeRate(String timestamp, Map<String, Float> quotes) {
        this.timestamp = timestamp;
        this.quotes = quotes;
    }
}
