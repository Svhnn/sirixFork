package io.sirix.utils;

import java.util.HashMap;
import java.util.Map;

public class ToUIntVarCoverageTool {
    // Data structure to hold coverage information
    public static Map<Integer, Boolean> branchCoverage = new HashMap<>();

    // Initialize coverage map with branch IDs
    static {
        branchCoverage.put(1, false); // Branch 1: B is null
        branchCoverage.put(2, false); // Branch 2: B length is 1
        branchCoverage.put(3, false); // Branch 3: B length is 2
        branchCoverage.put(4, false); // Branch 4: B length is 3
        branchCoverage.put(5, false); // Branch 4: B length is >3
    }

    public static void reset(){
        branchCoverage.put(1, false);
        branchCoverage.put(2, false);
        branchCoverage.put(3, false);
        branchCoverage.put(4, false);
        branchCoverage.put(5, false);
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
