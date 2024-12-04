package com.example.firstCalc;

import com.example.firstCalc.service.impl.CalcServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final CalcServiceImpl calculator = new CalcServiceImpl();

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "-2, -3, -5",
            "-2, 3, 1",
            "0, 0, 0",
            "1.5, 2.5, 4.0",
            "1e308, 1e308, Infinity"
    })
    void testAddition(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "-2, -3, 1",
            "-2, 3, -5",
            "-2532.3, 312.5, -2844.8",
            "0, 0, 0",
            "1e308, -1e308, 2e308"
    })
    void testSubtraction(double a, double b, double expected) {
        assertEquals(expected, calculator.sub(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-2, -3, 6",
            "-2, 3, -6",
            "0, 1000, 0",
            "-2532.3, 312.5, -791343.75",
            "2532.3, 312.5, 791343.75",
            "1e154, 1e154, 1.0E308",
            "1e154, 1e155, Infinity",
            "-1e154, 1e155, -Infinity"
    })
    void testMultiplication(double a, double b, double expected) {
        assertEquals(expected, calculator.mul(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "-6, -3, 2",
            "-6, 3, -2",
            "0, 1, 0",
            "1e308, 2, 5e307", // Граничный случай
            "1, 0, NaN" // Проверка деления на 0
    })
    void testDivision2(double a, int b, double expected) {
        if (b == 0) {
            assertThrows(ArithmeticException.class, () -> calculator.div(a, b));
        } else {
            assertEquals(expected, calculator.div(a, b));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "-6, -3, 2",
            "-6, 3, -2",
            "0, 1, 0",
            "2532.3, 312.5, 8.10336",
            "-2532.3, 312.5, -8.10336",
            "1e308, 2, 5e307", // Граничный случай
            "1, 0, Infinity", // Проверка деления на 0
            "-1, 0, -Infinity" // Проверка деления на 0
    })
    void testDivision(double a, double b, double expected) {
        if (b == 0) {
            if (a < 0) {
                assertEquals(Double.NEGATIVE_INFINITY, calculator.div(a, b));
            } else {
                assertEquals(Double.POSITIVE_INFINITY, calculator.div(a, b));
            }
        } else {
            assertEquals(expected, calculator.div(a, b));
        }
    }

    @Test
    void testEdgeCases() {
        // Деление на ноль
        assertThrows(ArithmeticException.class, () -> calculator.div(1, 0), "На 0 делить нельзя!");

        // Граничные значения
        assertEquals(Double.POSITIVE_INFINITY, calculator.div(Double.MAX_VALUE, 1e-308));
        assertEquals(Double.NEGATIVE_INFINITY, calculator.div(-Double.MAX_VALUE, 1e-308));

        // Нан
        assertEquals(Double.NaN, calculator.div(0, 0));
    }

    @Test
    void testLog() {
        assertEquals(1.3862943611198906, calculator.log(4));
    }

    @Test
    void testImpossibleCases() {
        // Тест, который должен завалиться
        assertNotEquals(5, calculator.add(2, 2)); // Ожидаемое поведение - тест не пройдёт
    }
}
