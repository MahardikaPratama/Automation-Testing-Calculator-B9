package com.calculator;

public class Compute {
    private final Calculate calculate = new Calculate();

    public String performCalculation(int num1, int num2, String operator) {
        try {
            switch (operator) {
                case "+":
                    return String.valueOf(calculate.add(num1, num2));
                case "-":
                    return String.valueOf(calculate.subtract(num1, num2));
                case "*":
                    return String.valueOf(calculate.multiply(num1, num2));
                case "/":
                    return String.format("%.2f", calculate.divide(num1, num2));
                default:
                    return "Error: Operator tidak valid";
            }
        } catch (ArithmeticException e) {
            return "Error: Hasil perhitungan melebihi range short";
        }
    }
}