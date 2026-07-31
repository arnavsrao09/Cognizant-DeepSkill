package com.bank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calculator = null;
    }

    @Test
    public void testAddition() {

        int a = 10;
        int b = 20;

        int result = calculator.add(a, b);

        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {

        int a = 20;
        int b = 5;

        int result = calculator.subtract(a, b);

        assertEquals(15, result);
    }

    @Test
    public void testMultiplication() {

        int a = 6;
        int b = 7;

        int result = calculator.multiply(a, b);

        assertEquals(42, result);
    }

    @Test
    public void testDivision() {

        int a = 20;
        int b = 4;

        int result = calculator.divide(a, b);

        assertEquals(5, result);
    }
}