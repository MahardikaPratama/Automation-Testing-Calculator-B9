package com.calculator;

public class Compute {

    public String performCalculation(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf((int)(num1 + num2));
            case "-":
                return String.valueOf((int)(num1 - num2));
            case "*":
                return String.valueOf((int)(num1 * num2));
            case "/":
                return String.format("%.2f", (float)(num1 / num2));
            default:
                return "Error: Operator tidak valid";
        }
    }
}