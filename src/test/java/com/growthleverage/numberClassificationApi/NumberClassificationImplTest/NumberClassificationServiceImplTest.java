package com.growthleverage.numberClassificationApi.NumberClassificationImplTest;
import com.growthleverage.numberClassificationApi.service.NumberClassificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NumberClassificationServiceImplTest {

    private NumberClassificationServiceImpl numberClassificationService;

    @BeforeEach
    void setup(){
        numberClassificationService = new NumberClassificationServiceImpl();
    }


    @Test
    public void test_primeNumber(){
        assertTrue(numberClassificationService.isPrime(7));
        assertFalse(numberClassificationService.isPrime(10));
    }

    @Test
    public void test_perfectNumber(){
        assertTrue(numberClassificationService.isPerfect(6));
        assertFalse(numberClassificationService.isPerfect(10));
    }

    @Test
    public void test_ArmStrongNumber(){
        assertTrue(numberClassificationService.isArmStrong(153));
        assertFalse(numberClassificationService.isArmStrong(123));
    }

    @Test
    public void test_oddNumber(){
        assertTrue(numberClassificationService.isOdd(153));
        assertFalse(numberClassificationService.isOdd(120));
    }

    @Test
    public void test_getProperties(){
        assertTrue(numberClassificationService.getProperties(153).contains("armstrong"));
        assertTrue(numberClassificationService.getProperties(7).contains("odd"));
        assertTrue(numberClassificationService.getProperties(6).contains("even"));
    }

    @Test
    void testDigitSum() {
        assertEquals(6, numberClassificationService.calculateDigitSum(123));
        assertEquals(9, numberClassificationService.calculateDigitSum(153));
    }
}