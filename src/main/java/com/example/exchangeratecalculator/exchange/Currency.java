package com.example.exchangeratecalculator.exchange;

public enum Currency {

    KRW("한국"),JPY("일본"),PHP("필리핀");
    private final String description;

    Currency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
