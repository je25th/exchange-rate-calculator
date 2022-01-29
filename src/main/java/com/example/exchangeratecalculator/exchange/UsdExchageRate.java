package com.example.exchangeratecalculator.exchange;

import lombok.Getter;

import java.util.Map;

@Getter
public class UsdExchageRate {
    private String timestamp;
    private Map<String, Float> quotes;

    public UsdExchageRate(String timestamp, Map<String, Float> quotes) {
        this.timestamp = timestamp;
        this.quotes = quotes;
    }
}
