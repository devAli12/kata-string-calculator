package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void should_return_0_for_empty(){
        Calculator calculator= new Calculator();
        Assertions.assertEquals(0,calculator.add(""));
    }
    @Test
    public void should_return_1_for_string_1(){
        Calculator calculator= new Calculator();
        Assertions.assertEquals(1,calculator.add("1"));
    }
    @Test
    public void should_return_3_for_string_12(){
        Calculator calculator= new Calculator();
        Assertions.assertEquals(3,calculator.add("1\n2"));
    }

    @Test
    public void should_return_6_for_string123(){
        Calculator calculator = new Calculator();
        Assertions.assertEquals(6,calculator.add("1\n2\n3"));
    }
    @Test
    public void should_return_6_for_string_123_with_delimiter(){
        Calculator calculator = new Calculator();
        Assertions.assertEquals(6,calculator.add("//[;]\n1;2;3"));
    }
    @Test
    public void should_throw_exception_when_there_are_negative_numbers(){
        Calculator calculator = new Calculator();
        assertThrows(RuntimeException.class, ()->calculator.add("-1,-2,-3"));

    }

    @Test
    public void should_return_6_with_long_delimiter(){
        Calculator calculator = new Calculator();
        assertEquals(6,calculator.add("//[***]\n1***2***3"));

    }
    @Test
    public void should_return_2_when_2_delimiter_1001(){
        Calculator calculator = new Calculator();
        assertEquals(2,calculator.add("2,1001"));

    }

    @Test
    public void should_return_6_with_multi_delimiters(){
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("//[*][;]\n1*2;3"));

    }

    @Test
    public void should_return_6_with_multi_delimiters_which_are_long(){
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));

    }
}
