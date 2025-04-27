package com.calculator;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Validate validate = new Validate();
            Compute compute = new Compute();

            System.out.println("------------------------------");
            System.out.println("**** Kalkulator Sederhana ****");
            System.out.println("------------------------------\n");

            int num1 = inputNumber(scanner, validate, "Masukkan angka pertama: ");
            int num2 = inputNumber(scanner, validate, "Masukkan angka kedua: ");
            String operator = inputOperator(scanner, validate, num2);

            String result = compute.performCalculation(num1, num2, operator);
            System.out.println("Hasil dari " + num1 + " " + operator + " " + num2 + " = " + result);
        }
    }

    private static int inputNumber(Scanner scanner, Validate validate, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return validate.validateNumber(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
    }

    private static String inputOperator(Scanner scanner, Validate validate, int num2) {
        while (true) {
            System.out.print("Masukkan operator (+, -, *, /): ");
            String operator = scanner.nextLine();
            try {
                validate.validateOperator(operator);
                if (operator.equals("/")) {
                    validate.validateDivision(num2);
                }
                return operator;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
    }
}
