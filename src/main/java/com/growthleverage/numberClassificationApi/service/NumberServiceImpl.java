package com.growthleverage.numberClassificationApi.service;

import com.growthleverage.numberClassificationApi.exception.InvalidNumberException;
import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberServiceImpl implements NumberService {

    private final NumberClassificationService numberClassificationService;
    private final FunFactService funFactService;

    public NumberServiceImpl(NumberClassificationService numberClassificationService, FunFactService funFactService) {
        this.numberClassificationService = numberClassificationService;
        this.funFactService = funFactService;
    }

    @Override
    public NumberResponseDto classifyNumber(NumberRequestDto requestDto) {
        try {
            Integer number = requestDto.getNumber();
            if (number == null) {
                throw new InvalidNumberException("Number must not be null");
            }
            boolean isPrime = numberClassificationService.isPrime(number);
            boolean isPerfect = numberClassificationService.isPerfect(number);
            List<String> properties = numberClassificationService.getProperties(number);
            int digitSum = numberClassificationService.calculateDigitSum(number);
            String funFact = funFactService.getFunFact(number);
            return new NumberResponseDto(number, isPrime, isPerfect, properties,
                                                            digitSum, funFact);

        } catch (NumberFormatException | InvalidNumberException e) {
            throw new InvalidNumberException(e.getMessage());
        } catch (Exception e) {
            return new NumberResponseDto(requestDto.toString(), true);
        }
    }
}


