package com.calculator;

import java.util.Scanner;

public class MainApp {
    /*
    * Fungsi ini digunakan sebagai entry point untuk menjalankan aplikasi kalkulator
    */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            runCalculator(scanner);
        }
    }

    /*
    * Fungsi ini digunakan untuk menjalankan alur utama kalkulator
    */
    private static void runCalculator(Scanner scanner) {
        Validate validate = new Validate();
        Compute compute = new Compute();
        printHeader();
        boolean isRunning = true;

        while (isRunning) {
            performCalculationFlow(scanner, validate, compute);

            if (!askRepeat(scanner)) {
                printExitMessage();
                isRunning = false;
            }
        }
    }

    /*
    * Fungsi ini digunakan untuk menampilkan header kalkulator
    */
    private static void printHeader() {
        System.out.println("------------------------------------------");
        System.out.println("*******    Kalkulator Sederhana    *******");
        System.out.println("------------------------------------------");
    }

    /*
    * Fungsi ini menangani alur perhitungan satu kali
    */
    private static void performCalculationFlow(Scanner scanner, Validate validate, Compute compute) {
        System.out.println();

        int num1 = inputNumber(scanner, validate, "Masukkan angka pertama: ");
        int num2 = inputNumber(scanner, validate, "Masukkan angka kedua: ");
        String operator = inputOperator(scanner, validate, num2);

        String result = compute.performCalculation(num1, num2, operator);
        displayResult(num1, num2, operator, result);
    }

    /*
    * Fungsi ini menampilkan hasil perhitungan
    */
    private static void displayResult(int num1, int num2, String operator, String result) {
        System.out.println("Hasil dari " + num1 + " " + operator + " " + num2 + " = " + result);
        System.out.println();
    }

    /*
    * Fungsi ini menanyakan kepada user apakah ingin mengulang kalkulasi
    */
    private static boolean askRepeat(Scanner scanner) {
        while (true){    
            System.out.print("Apakah Anda ingin menghitung lagi? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")){
                return true;
            } else if (choice.equals("n")){
                return false;
            } else {
                System.out.println("Error: Pilihan tidak valid. Silakan masukkan 'y' atau 'n'.");
                System.out.println();
            }
        }
    }

    /*
    * Fungsi ini menampilkan pesan perpisahan
    */
    private static void printExitMessage() {
        System.out.println("\nTerima kasih telah menggunakan kalkulator!");
        System.out.println();
    }

    /*
    * Fungsi ini digunakan untuk menampilkan prompt dan membaca input dari pengguna
    */
    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /*
    * Fungsi ini digunakan untuk memvalidasi apakah input dari user berupa angka dan berada dalam range yang diperbolehkan
    */
    private static boolean isValidNumberInput(Validate validate, String input) {
        if (!validate.isNumeric(input)) {
            System.out.println("Error: Input harus berupa angka");
            System.out.println("Silakan masukkan angka yang valid!\n");
            return false;
        }

        if (!validate.isInRange(input)) {
            System.out.println("Error: Angka harus berada pada range -32,768 hingga 32,767");
            System.out.println("Silakan masukkan angka yang valid!\n");
            return false;
        }

        return true;
    }

    /*
    * Fungsi ini digunakan untuk mengubah input string yang valid menjadi bilangan bulat
    */
    private static int parseValidNumber(String input) {
        return Integer.parseInt(input);
    }

    /*
    * Fungsi ini digunakan untuk membaca dan memvalidasi input angka dari pengguna hingga input valid diberikan
    */
    private static int inputNumber(Scanner scanner, Validate validate, String prompt) {
        while (true) {
            String input = getInput(scanner, prompt);

            if (isValidNumberInput(validate, input)) {
                return parseValidNumber(input);
            }
        }
    }


    /*
    * Fungsi ini digunakan untuk menampilkan prompt dan membaca input operator dari pengguna
    */
    private static String getOperatorInput(Scanner scanner) {
        System.out.print("Masukkan operator (+, -, *, /): ");
        return scanner.nextLine();
    }

    /*
    * Fungsi ini digunakan untuk memvalidasi input operator dan kondisi pembagian
    */
    private static boolean isValidOperatorInput(Validate validate, String operator, int num2) {
        if (!validate.isValidOperator(operator)) {
            System.out.println("Error: Operator yang diperbolehkan hanya +, -, *, /");
            System.out.println("Silakan masukkan operator yang valid!\n");
            return false;
        }

        if (operator.equals("/") && !validate.isValidDivision(num2)) {
            System.out.println("Error: Pembagi tidak boleh bernilai nol");
            System.out.println("Pilih operator lain, selain pembagian!\n");
            return false;
        }

        return true;
    }

    /*
    * Fungsi ini digunakan untuk membaca dan memvalidasi input operator dari pengguna hingga valid
    */
    private static String inputOperator(Scanner scanner, Validate validate, int num2) {
        while (true) {
            String operator = getOperatorInput(scanner);

            if (isValidOperatorInput(validate, operator, num2)) {
                return operator;
            }
        }
    }
}
