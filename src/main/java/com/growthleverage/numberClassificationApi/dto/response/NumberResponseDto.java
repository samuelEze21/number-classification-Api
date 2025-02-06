package com.growthleverage.numberClassificationApi.dto.response;
import java.util.List;

public class NumberResponseDto {
    private int number;
    private boolean isPrime;
    private boolean isPerfect;
    private List<String> properties;
    private int digitSum;
    private String funFact;
    private Boolean error;
    private String errorMessage;

    public NumberResponseDto(int number, boolean isPrime, boolean isPerfect, List<String> properties, int digitSum, String funFact) {
        this.number = number;
        this.isPrime = isPrime;
        this.isPerfect = isPerfect;
        this.properties = properties;
        this.digitSum = digitSum;
        this.funFact = funFact;
        this.error = false;
        this.errorMessage = null;
    }

    public NumberResponseDto(String errorMessage) {
        this.error = true;
        this.errorMessage = errorMessage;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public boolean isPerfect() {
        return isPerfect;
    }

    public List<String> getProperties() {
        return properties;
    }

    public int getDigitSum() {
        return digitSum;
    }

    public String getFunFact() {
        return funFact;
    }

    public Boolean getError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
