package com.growthleverage.numberClassificationApi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberRequestDto {
    private int number;

    public NumberRequestDto(int number) {
        this.number = number;
    }

    public NumberRequestDto() {
    }

}
