package com.growthleverage.numberClassificationApi.service;

import com.growthleverage.numberClassificationApi.exception.InvalidNumberException;
import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;
import com.growthleverage.numberClassificationApi.exception.ExternalApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberServiceImpl implements NumberService {

    private static final Logger logger = LoggerFactory.getLogger(NumberServiceImpl.class);
    private final NumberClassificationService numberClassificationService;
    private final FunFactService funFactService;

    public NumberServiceImpl(NumberClassificationService numberClassificationService, FunFactService funFactService) {
        this.numberClassificationService = numberClassificationService;
        this.funFactService = funFactService;
    }

    @Override
    public NumberResponseDto classifyNumber(NumberRequestDto requestDto) {
        if (requestDto == null) {
            throw new InvalidNumberException("Number must not be null");
        }

        try {
            int number = requestDto.getNumber();
            logger.info("Classifying number: {}", number);

            boolean isPrime = numberClassificationService.isPrime(number);
            boolean isPerfect = numberClassificationService.isPerfect(number);
            List<String> properties = numberClassificationService.getProperties(number);
            int digitSum = numberClassificationService.calculateDigitSum(number);
            String funFact;
            try {
                funFact = funFactService.getFunFact(number);
            } catch (ExternalApiException e) {
                logger.warn("Fun fact API failed: {}", e.getMessage());
                funFact = "Fun fact not available due to an API issue.";
            }
            return new NumberResponseDto(number, isPrime, isPerfect, properties, digitSum, funFact);

        } catch (Exception e) {
            logger.error("Unexpected error while classifying number: {}", e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred. Please try again later.");
        }
    }
}
