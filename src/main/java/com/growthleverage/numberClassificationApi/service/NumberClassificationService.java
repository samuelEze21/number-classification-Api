package com.growthleverage.numberClassificationApi.service;
import java.util.List;


public interface NumberClassificationService {
    boolean isPrime(int number);
    boolean isPerfect(int number);
    boolean isArmStrong(int number);
    boolean isOdd(int number);
//    boolean isEven(int number);
    List<String> getProperties(int number);
    int calculateDigitSum (int number);
}
