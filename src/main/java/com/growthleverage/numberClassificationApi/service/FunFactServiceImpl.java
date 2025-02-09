package com.growthleverage.numberClassificationApi.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactServiceImpl implements FunFactService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String NUMBER_API_URL = "https://numbersapi.com";



    @Override
    public String getFunFact(int number) {
        try {
            return restTemplate.getForObject(NUMBER_API_URL + "/" + number, String.class);
        } catch (Exception e) {
            return "Fun fact not available";
        }
    }

}
