package com.example.exchangeratecalculator.exchange;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    @Test
    void getExchangeRateTest() {
        CalculatorService calculatorService = new CalculatorService();
        float result = calculatorService.getExchangeRate(Currency.JPY);
        System.out.println(result);
        assertThat(result).isNotSameAs(-1).isNotSameAs(null);
    }

    @Test
    void calculateTest() {

    }
}