package com.growthleverage.numberClassificationApi.controller;
import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;
import com.growthleverage.numberClassificationApi.service.NumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/classify")
    public NumberResponseDto classifyNumber(@RequestParam NumberRequestDto numberRequestDto) {
        return numberService.classifyNumber(numberRequestDto);
    }

}
