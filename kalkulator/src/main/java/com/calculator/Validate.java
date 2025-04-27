package com.calculator;

public class Validate {

    public int validateNumber(String numStr) throws NumberFormatException, IllegalArgumentException {
        int numInt;
        int MIN_RANGE = -32768;
        int MAX_RANGE = 32767;

        try {
            numInt = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input harus berupa angka");
        }
        
        if (numInt < MIN_RANGE || numInt > MAX_RANGE) {
            throw new IllegalArgumentException("Angka harus berada pada range -32,768 hingga 32,767");
        }
        
        return (int)numInt;
    }

    public void validateOperator(String operator) throws IllegalArgumentException {
        if (!operator.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("Operator yang diperbolehkan hanya +, -, *, /");
        }
    }

    public void validateDivision(int num2) throws IllegalArgumentException {
        if (num2 == 0) {
            throw new IllegalArgumentException("Pembagi tidak boleh bernilai nol");
        }
    }
}
