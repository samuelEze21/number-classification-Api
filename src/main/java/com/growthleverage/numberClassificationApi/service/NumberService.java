package com.growthleverage.numberClassificationApi.service;


import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;

public interface NumberService {
    NumberResponseDto classifyNumber (NumberRequestDto requestDto);
}
