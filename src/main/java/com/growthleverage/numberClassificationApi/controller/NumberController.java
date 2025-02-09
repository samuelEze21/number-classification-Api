package com.growthleverage.numberClassificationApi.controller;
import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;
import com.growthleverage.numberClassificationApi.service.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/classify-number")
    public ResponseEntity<NumberResponseDto> classifyNumber(@RequestParam Integer number) {
        NumberRequestDto requestDto = new NumberRequestDto(number);
        NumberResponseDto responseDto = numberService.classifyNumber(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
