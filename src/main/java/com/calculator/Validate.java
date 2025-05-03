package com.calculator;

public class Validate {
    private static final int MIN_RANGE = -32768;
    private static final int MAX_RANGE = 32767;

    /*
     * Fungsi ini digunakan untuk memvalidasi apakah input dari user berupa angka
     */
    public boolean isNumeric(String numStr) {
        if (numStr.matches("-?\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Fungsi ini digunakan untuk memvalidasi apakah angka berada dalam range yang diperbolehkan
     */
    public boolean isInRange(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num < MIN_RANGE || num > MAX_RANGE) {
            return false;
        } else {
            return true;
        }
    }

        /*
     * Fungsi ini digunakan untuk memvalidasi apakah operator yang dimasukkan valid (+, -, *, /)
     */
    public boolean isValidOperator(String operator) {
        if (operator.matches("[+\\-*/]")){
            return true;
        } else {
            return false;
        }
    }

    /*
     * Fungsi ini digunakan untuk memvalidasi apakah pembagian tidak dilakukan oleh nol
     */
    public boolean isValidDivision(int num2) {
        if (num2 != 0){
            return true;
        } else {
            return false;
        }
    }
}
