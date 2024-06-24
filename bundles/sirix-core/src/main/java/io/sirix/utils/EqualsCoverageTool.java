package io.sirix.utils;

import java.util.HashMap;
import java.util.Map;

public class EqualsCoverageTool {

    // Data structure to hold coverage information
    public static Map<Integer, Boolean> branchCoverage = new HashMap<>();
    private static double totalCoverage = 0.0;

    // Initialize coverage map with branch IDs
    static {
        branchCoverage.put(1, false); // Branch 1: Fail if one is null.
        branchCoverage.put(2, false); // Branch 2: Fail if the values are not of equal length.
        branchCoverage.put(3, false); // Branch 3: Fail if a single byte does not match.
        branchCoverage.put(4, false); // Branch 3: Values must be equal if we reach here.
    }

    public static void reset(){
        branchCoverage.put(1, false);
        branchCoverage.put(2, false);
        branchCoverage.put(3, false);
        branchCoverage.put(4, false);
    }

    public static void printCoveragePercentage() {
        int totalTests = 4;

        int coveredBranches = 0;
        if (EqualsCoverageTool.branchCoverage.get(1)) {
            coveredBranches++;
        }
        if (EqualsCoverageTool.branchCoverage.get(2)) {
            coveredBranches++;
        }
        if (EqualsCoverageTool.branchCoverage.get(3)) {
            coveredBranches++;
        }
        if (EqualsCoverageTool.branchCoverage.get(4)) {
            coveredBranches++;
        }

        double coveragePercentage = (double) coveredBranches / totalTests * 100;
        totalCoverage += coveragePercentage;
        System.out.printf("Coverage Percentage current Branch: %.2f%%\n", coveragePercentage);
        System.out.printf("Coverage Percentage Total: %.2f%% \n", totalCoverage);
        reset();
    }

    public static void printCoverage() {
        System.out.println("Coverage Information:");
        for (Map.Entry<Integer, Boolean> entry : branchCoverage.entrySet()) {
            int branchId = entry.getKey();
            boolean hit = entry.getValue();
            System.out.printf("Branch %d: %s%n", branchId, hit ? "Hit" : "Not Hit");
        }
        printCoveragePercentage();
        reset();
    }
}
