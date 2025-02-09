package com.growthleverage.numberClassificationApi.dto.request;

public class NumberRequestDto {
    private int number;

    public NumberRequestDto(int number) {
        this.number = number;
    }
    public NumberRequestDto() {
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
