package io.sirix.utils;

import java.util.HashMap;
import java.util.Map;

public class EqualsCoverageTool {

    // Data structure to hold coverage information
    public static Map<Integer, Boolean> branchCoverage = new HashMap<>();

    // Initialize coverage map with branch IDs
    static {
        branchCoverage.put(1, false); // Branch 1: Check if either mValue1 or mValue2 is null
        branchCoverage.put(2, false); // Branch 2: Check if lengths are equal
        branchCoverage.put(3, false); // Branch 3: Compare each byte
    }

    public static void reset(){
        branchCoverage.put(1, false);
        branchCoverage.put(2, false);
        branchCoverage.put(3, false);
    }

    public static void printCoverage() {
        System.out.println("Coverage Information:");
        for (Map.Entry<Integer, Boolean> entry : branchCoverage.entrySet()) {
            int branchId = entry.getKey();
            boolean hit = entry.getValue();
            System.out.printf("Branch %d: %s%n", branchId, hit ? "Hit" : "Not Hit");
        }
        reset();
    }
}
