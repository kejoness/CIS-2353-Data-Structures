/*
 * Kayla Jones
 * CIS 2353
 * Winter 2025
 * Prof. John P. Baugh
 */

package proj4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TriageSimulatorMain {
    public static void main(String[] args) {
        TriageSimulator simulator = new TriageSimulator();

        // read patients from a file and add them to the simulator
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/kayla/CIS2353 Projects/CIS-2353-Data-Structures/proj4/patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                simulator.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Patients will be seen in this order:");
        while (!simulator.isEmpty()) {
            String nextPatient = simulator.remove();
            if (nextPatient != null) {
                System.out.println(nextPatient);
            }
        }
    }
}
