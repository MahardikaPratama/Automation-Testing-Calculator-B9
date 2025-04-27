package com.calculator;

public class Compute {

    public String performCalculation(short num1, short num2, String operator) {
        try {
            switch (operator) {
                case "+":
                    return String.valueOf((short)(num1 + num2));
                case "-":
                    return String.valueOf((short)(num1 - num2));
                case "*":
                    return String.valueOf((short)(num1 * num2));
                case "/":
                    return String.format("%.2f", (float)(num1 / num2));
                default:
                    return "Error: Operator tidak valid";
            }
        } catch (ArithmeticException e) {
            return "Error: Hasil perhitungan melebihi range short";
        }
    }
}