package org.example.calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileHelper {
    private static final String RESULT_FILE = "results.txt";
    static synchronized void saveResultToFile(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE, true))) {
            writer.write(result);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania wyniku do pliku: " + e.getMessage());
        }
    }
}
