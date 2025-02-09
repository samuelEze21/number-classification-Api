package com.growthleverage.numberClassificationApi.service;


import com.growthleverage.numberClassificationApi.exception.ExternalApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactServiceImpl implements FunFactService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String NUMBER_API_URL = "https://numbersapi.com";

    @Override
    public String getFunFact(Integer number) {
        String url = "https://numbersapi.com/" + number;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new ExternalApiException("Fun fact API returned an invalid response");
            }
        } catch (Exception e) {
            throw new ExternalApiException("Failed to fetch fun fact: " + e.getMessage());
        }
    }

}
