package com.calculator;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();
        Compute compute = new Compute();
        
        System.out.println("------------------------------");
        System.out.println("**** Kalkulator Sederhana ****");
        System.out.println("------------------------------");
        System.out.println();
        
        try {
            // Input angka pertama dengan validasi langsung
            short num1 = 0;
            boolean validNum1 = false;
            while (!validNum1) {
                System.out.print("Masukkan angka pertama: ");
                String num1Str = scanner.nextLine();
                try {
                    num1 = validate.validateNumber(num1Str);
                    validNum1 = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println();
                }
            }

            // Input angka kedua dengan validasi langsung
            short num2 = 0;
            boolean validNum2 = false;
            while (!validNum2) {
                System.out.print("Masukkan angka kedua: ");
                String num2Str = scanner.nextLine();
                try {
                    num2 = validate.validateNumber(num2Str);
                    validNum2 = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println();
                }
            }

            // Input operator dengan validasi langsung
            String operator = "";
            boolean validOperator = false;
            while (!validOperator) {
                System.out.print("Masukkan operator (+, -, *, /): ");
                operator = scanner.nextLine();
                try {
                    validate.validateOperator(operator);
                    
                    // Validasi khusus pembagian
                    if (operator.equals("/")) {
                        validate.validateDivision(num2);
                    }
                    validOperator = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println();
                }
            }

            // Lakukan perhitungan dan tampilkan hasil
            String result = compute.performCalculation(num1, num2, operator);
            System.out.println("Hasil " + num1 + " " + operator + " " + num2 + " = " + result);
            
        } finally {
            scanner.close();
        }
    }
}