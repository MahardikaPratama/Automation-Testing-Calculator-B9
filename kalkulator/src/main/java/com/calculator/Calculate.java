package com.calculator;

public class Calculate {
    /*
     * Fungsi ini digunakan untuk melakukan penjumlahan
     */
    public int add(int a, int b) {
        return (int) (a + b);
    }

    /*
     * Fungsi ini digunakan untuk melakukan pengurangan
     */
    public int subtract(int a, int b) {
        return (int) (a - b);
    }

    /*
     * Fungsi ini digunakan untuk melakukan perkalian
     */
    public int multiply(int a, int b) {
        return (int) (a * b);
    }

    /*
     * Fungsi ini digunakan untuk melakukan pembagian
     */
    public float divide(int a, int b) {
        return (float) a / b;
    }
}