package com.growthleverage.numberClassificationApi.dto.response;
import java.util.List;

public class NumberResponseDto {
    private Integer number;
    private Boolean isPrime;
    private Boolean isPerfect;
    private List<String> properties;
    private Integer digitSum;
    private String funFact;
    private Boolean error;

    public NumberResponseDto(int number, boolean isPrime, boolean isPerfect, List<String> properties, int digitSum, String funFact) {
        this.number = number;
        this.isPrime = isPrime;
        this.isPerfect = isPerfect;
        this.properties = properties;
        this.digitSum = digitSum;
        this.funFact = funFact;
        this.error = false;
    }

    public NumberResponseDto(String number, boolean error) {
        this.number = number != null ? Integer.valueOf(number) : null;
        this.error = error;
    }

    public Integer getNumber() {
        return number;
    }

    public Boolean getIsPrime() {
        return isPrime;
    }

    public Boolean getIsPerfect() {
        return isPerfect;
    }

    public List<String> getProperties() {
        return properties;
    }

    public Integer getDigitSum() {
        return digitSum;
    }

    public String getFunFact() {
        return funFact;
    }

    public Boolean getError() {
        return error;
    }
}
