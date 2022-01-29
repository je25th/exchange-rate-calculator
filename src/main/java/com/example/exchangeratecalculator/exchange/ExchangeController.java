package com.example.exchangeratecalculator.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator() {
        return "exchange/calculator";
    }

    @PostMapping("/calculator.json")
    public void calculate(Model model) {
        model.addAttribute("result", calculatorService.calculate());
    }
}
