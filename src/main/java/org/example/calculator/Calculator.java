package org.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        executeAction(scanner);
    }

    private static void executeAction(Scanner scanner) {
        while (true) {
            try {
                int selectionResult = Integer.parseInt(showMenu(scanner));
                if (selectionResult == 0) {
                    break;
                }
                switch (selectionResult) {
                    case 1:
                        performFactorialCalculation(scanner);
                        break;
                    case 2:
                        performPowerCalculation(scanner);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Proszę wprowadzić poprawną liczbę.");
            }
        }
    }

    private static void performPowerCalculation(Scanner scanner) {
        System.out.print("Wprowadź liczbę do obliczenia stopnia: ");
        String input = scanner.nextLine();
        System.out.print("Wprowadź stopień: ");
        String power = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            int powerInt = Integer.parseInt(power);
            new PowCalculator(number, powerInt).start();
        } catch (NumberFormatException e) {
            System.out.println("Proszę wprowadzić poprawną liczbę całkowitą.");
        }
    }

    private static void performFactorialCalculation(Scanner scanner) {
        System.out.print("Wprowadź liczbę do obliczenia silni: ");
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            new FactorialCalculator(number).start();
        } catch (NumberFormatException e) {
            System.out.println("Proszę wprowadzić poprawną liczbę całkowitą.");
        }
    }

    private static String showMenu(Scanner scanner) {
        System.out.println("Wybierz 1 - jeżeli potrzebujesz obliczyć silnię");
        System.out.println("Wybierz 2 - jeżeli potrzebujesz obliczyć stopień");
        System.out.println("Wybierz 0 - jeżeli chcesz skończyć działanie programu");
        return scanner.nextLine();
    }
}
