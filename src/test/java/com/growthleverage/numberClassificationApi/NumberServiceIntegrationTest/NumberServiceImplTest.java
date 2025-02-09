package com.growthleverage.numberClassificationApi.NumberServiceIntegrationTest;

import com.growthleverage.numberClassificationApi.dto.request.NumberRequestDto;
import com.growthleverage.numberClassificationApi.dto.response.NumberResponseDto;
import com.growthleverage.numberClassificationApi.service.NumberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NumberServiceImplTest {

    @Autowired
    private NumberServiceImpl numberService;

    @Test
    public void testClassifyNumber_validInput() {
        NumberRequestDto requestDto = new NumberRequestDto(371);
        NumberResponseDto response = numberService.classifyNumber(requestDto);
        assertNotNull(response);
        assertEquals(371, response.getNumber());
        assertFalse(response.getIsPrime());
        assertFalse(response.getIsPerfect());
        assertTrue(response.getProperties().contains("armstrong"));
        assertTrue(response.getProperties().contains("odd"));
        assertEquals(11, response.getDigitSum());
        assertNotNull(response.getFunFact());
        assertFalse(response.getError());
    }


}


