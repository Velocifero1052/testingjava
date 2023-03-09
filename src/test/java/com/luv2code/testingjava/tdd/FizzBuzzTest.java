package com.luv2code.testingjava.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void initFizzBuzz(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void testForDivisibleByThree(){
        var expected = "Fizz";
        assertEquals(expected, fizzBuzz.compute(3));
    }

    @Test
    void testDivisibleByFive(){
        var expected = "Buzz";
        assertEquals(expected, fizzBuzz.compute(5));
    }

    @Test
    void testDivisibleByThreeAndFive(){
        var expected = "FizzBuzz";
        assertEquals(expected, fizzBuzz.compute(15));
    }

    @Test
    void testForNotDivisible(){
        var expected = "4";
        assertEquals(expected, fizzBuzz.compute(Integer.parseInt(expected)));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "3,Fizz", "45,FizzBuzz", "50,Buzz", "52,52"})
    void parameterizedTest(int value, String expected){
        assertEquals(expected, fizzBuzz.compute(value));
    }

}
