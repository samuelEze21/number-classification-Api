package com.growthleverage.numberClassificationApi.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactServiceImpl implements FunFactService {

    private static final Logger logger = LoggerFactory.getLogger(FunFactServiceImpl.class);
    private final RestTemplate restTemplate;
    private final String numberApiUrl;

    public FunFactServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        // Load .env variables using dotenv
        Dotenv dotenv = Dotenv.load();
        this.numberApiUrl = dotenv.get("NUMBER_API_URL", "https://numbersapi.com");
    }

    @Override
    public String getFunFact(int number) {
        String url = numberApiUrl + "/" + number + "/math";
        try {
            logger.info("Fetching fun fact for number: {}", number);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

            if (responseEntity.getBody() == null || responseEntity.getBody().isEmpty()) {
                logger.warn("Received empty response from Numbers API for number: {}", number);
                return "No fun fact available at the moment.";
            }

            logger.info("Received fun fact: {}", responseEntity.getBody());
            return responseEntity.getBody();

        } catch (RestClientException e) {
            logger.error("Error fetching fun fact from Numbers API: {}", e.getMessage());
            return "Fun fact not available due to an error.";
        }
    }
}
