package com.example.exchangeratecalculator.exchange;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CalculatorService {

    private static UsdExchageRate usdExchageRate;

    public UsdExchageRate getExchageRate(Currency exchageFor) {
        if (usdExchageRate != null) {
            return new UsdExchageRate(usdExchageRate.getTimestamp(), usdExchageRate.getQuotes());
        }

        String url = "http://apilayer.net/api/live?access_key=e6c941201b03795db9f6f739fbc973a4&currencies=KRW,JPY,PHP&source=USD&format=1";

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(factory);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<UsdExchageRate> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, UsdExchageRate.class);
        usdExchageRate = new UsdExchageRate(result.getBody().getTimestamp(), result.getBody().getQuotes());
        return result.getBody();
    }

    public float calculate() {
        return 0;
    }
}
