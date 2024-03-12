package org.example.calculator;

import java.math.BigDecimal;

import static org.example.calculator.SaveFileHelper.saveResultToFile;

public class PowCalculator extends Thread {
    private double number;
    private int pow;

    public PowCalculator(double number, int pow) {
        this.number = number;
        this.pow = pow;
    }

    private BigDecimal calculatePow(double a, double b) {
        return BigDecimal.valueOf(Math.pow(a, b));
    }

    @Override
    public void run() {
        System.out.println("Obliczanie " + number + "^" + pow + " w tle...");

        BigDecimal numberPow = calculatePow(number, pow).setScale(15);
        String resultFormatted = formatResult(numberPow);

        System.out.println(number + "^" + pow + " (10 pierwszych cyfr) = " + resultFormatted);
        saveResultToFile(number + "^" + pow + " (10 pierwszych cyfr) = " + resultFormatted + "; " + ProcessHandle.current().pid() + "; "
                 + Thread.currentThread().getId());
    }

    private String formatResult(BigDecimal result) {
        String resultStr = result.toString();
        if (resultStr.length() > 10) {
            return resultStr.substring(0, 10);
        } else {
            return resultStr;
        }
    }
}
