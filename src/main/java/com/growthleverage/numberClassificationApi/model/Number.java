package com.growthleverage.numberClassificationApi.model;

import java.util.List;

public class Number {
    public Object number;
    public Boolean isPrime;
    private Boolean isPerfect;
    private List<String> properties;
    private Integer digitSum;
    private String funFact;
    private Boolean error;

    public Number(int number, Boolean isPrime, Boolean isPerfect, List<String> properties, Integer digitSum, String funFact, Boolean error) {
        this.number = number;
        this.isPrime = isPrime;
        this.isPerfect = isPerfect;
        this.properties = properties;
        this.digitSum = digitSum;
        this.funFact = funFact;
        this.error = error;
    }

    public Number(String number, boolean error){
        this.number = number;
        this.error = error;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Boolean getPrime() {
        return isPrime;
    }

    public void setPrime(Boolean prime) {
        isPrime = prime;
    }

    public Boolean getPerfect() {
        return isPerfect;
    }

    public void setPerfect(Boolean perfect) {
        isPerfect = perfect;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public Integer getDigitSum() {
        return digitSum;
    }

    public void setDigitSum(Integer digitSum) {
        this.digitSum = digitSum;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
