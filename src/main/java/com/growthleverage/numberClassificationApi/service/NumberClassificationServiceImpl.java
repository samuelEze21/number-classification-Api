package com.growthleverage.numberClassificationApi.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumberClassificationServiceImpl implements NumberClassificationService {

    @Override
    public boolean isPrime(int number) {
        if (number < 2) return false;

        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    @Override
    public boolean isPerfect(int number) {
        if (number <= 0) return false;

        int sumOfDivisors = 1;
        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                sumOfDivisors += divisor;
                int correspondingDivisor = number / divisor;
                if (divisor != correspondingDivisor) {
                    sumOfDivisors += correspondingDivisor;
                }
            }
        }
        return sumOfDivisors == number && number != 1;
    }

    @Override
    public boolean isArmStrong(int number) {
        int originalNumber = number;
        int sumOfPowers = 0;
        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int lastDigit = number % 10;
            sumOfPowers += (int) Math.pow(lastDigit, numberOfDigits);
            number /= 10;
        }
        return sumOfPowers == originalNumber;
    }

    @Override
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @Override
    public List<String> getProperties(int number) {
        List<String> properties = new ArrayList<>();
        if (isArmStrong(number)) {
            properties.add("armstrong");
        }
        properties.add(isOdd(number) ? "odd" : "even");
        return properties;
    }

    @Override
    public int calculateDigitSum(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
}
