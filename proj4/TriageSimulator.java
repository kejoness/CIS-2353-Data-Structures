/*
 * Kayla Jones
 * CIS 2353
 * Winter 2025
 * Prof. John P. Baugh
 */

package proj4;

import java.util.LinkedList;
import java.util.Queue;

public class TriageSimulator {
    private final Queue<String> priority1;
    private final Queue<String> priority2;
    private final Queue<String> priority3;
    
    // initializes three separate queues for each priority level
    public TriageSimulator() {
        priority1 = new LinkedList<>();
        priority2 = new LinkedList<>();
        priority3 = new LinkedList<>();
    }

    // adds a patient to the correct priority queue based on the triage code
    public void add(String lineFromFile) {
        String[] parts = lineFromFile.trim().split("\\s+");
        if (parts.length != 3) {
            System.out.println("Invalid line: " + lineFromFile);
            return;
        }

        String fullName = parts[0] + " " + parts[1];
        String triageCode = parts[2].toUpperCase();

        switch (triageCode) {
            case "AL", "HA", "ST" -> priority1.add(fullName);
            case "BL", "SF", "IW", "KS", "OT" -> priority2.add(fullName);
            case "HN" -> priority3.add(fullName);
            default -> System.out.println("Unknown code: " + triageCode);
        }
    }

    // removes and returns the next patient based on highest priority available
    public String remove() {
        if (!priority1.isEmpty()) {
            return priority1.poll();
        } else if (!priority2.isEmpty()) {
            return priority2.poll();
        } else if (!priority3.isEmpty()) {
            return priority3.poll();
        } else {
            return null;
        }
    }

    // checks if all three queues are empty (no patients left)
    public boolean isEmpty() {
        return priority1.isEmpty() && priority2.isEmpty() && priority3.isEmpty();
    }
}
