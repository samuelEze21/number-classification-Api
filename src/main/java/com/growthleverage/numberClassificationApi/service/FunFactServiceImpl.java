package com.growthleverage.numberClassificationApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactServiceImpl implements FunFactService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "http://numbersapi.com/";

    @Override
    public String getFunFact(int number) {
        try {
            return restTemplate.getForObject(API_URL + number, String.class);
        } catch (Exception e) {
            return "No fun fact found.";
        }
    }
}
