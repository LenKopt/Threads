package org.example.calculator;

import java.math.BigInteger;

import static org.example.calculator.SaveFileHelper.saveResultToFile;

public class FactorialCalculator extends Thread {
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Obliczanie " + number + "! w tle...");

        BigInteger factorial = calculateFactorial(number);
        String resultFormatted = formatResult(factorial);

        System.out.println(number + "! (10 pierwszych cyfr) = " + resultFormatted);
        saveResultToFile(number + "! (10 pierwszych cyfr) = " + resultFormatted + "; " + ProcessHandle.current().pid() + "; "
                + Thread.currentThread().getId());
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private String formatResult(BigInteger result) {
        String resultStr = result.toString();
        if (resultStr.length() > 10) {
            return resultStr.substring(0, 10);
        } else {
            return resultStr;
        }
    }
}







