package com.example.firstCalc.service.impl;

import com.example.firstCalc.service.CalcService;

public class CalcServiceImpl implements CalcService {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return Math.max(Double.NEGATIVE_INFINITY, Math.min(a * b, Double.POSITIVE_INFINITY));
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }

    @Override
    public double div(double a, int b) {
        if (b == 0) {
            if(a == 0) {
                return Double.NaN;
            }
            throw new ArithmeticException("На 0 делить нельзя!");
        }
        return a / b;
    }

    @Override
    public double log(double a) {
        return Math.log(a);
    }
}
