package com.example.exchangeratecalculator.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(Model model) {
        model.addAttribute("currencyList", Currency.values());
        return "exchange/calculator";
    }

    @ResponseBody
    @PostMapping("/getExchangeRate.json")
    public Map getExchangeRate(@ModelAttribute("exchangeFor") Currency exchangeFor) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", calculatorService.getExchangeRate(exchangeFor));
        return result;
    }

    @ResponseBody
    @PostMapping("/calculator.json")
    public Map calculate(@ModelAttribute("exchangeFor") Currency exchangeFor, @ModelAttribute("amount") float amount ) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", calculatorService.calculate(exchangeFor, amount));
        result.put("exchangeFor", exchangeFor);
        return result;
    }
}
