package io.sirix.utils;
import java.util.HashMap;
import java.util.Map;
public class BranchCoverageArrayTool {
    private static double totalCoverage = 0.0;
    public static Map<Integer, Boolean> branchCoverage = new HashMap<>();

    static {
        branchCoverage.put(1, false); // Branch 1: arr1 == arr2
        branchCoverage.put(2, false); // Branch 2: arr1 == null || arr2 == null
        branchCoverage.put(3, false); // Branch 3: arr1.length != arr2.length
        branchCoverage.put(4, false); // Branch 4: !Objects.equals(arr1[a], arr2[a])
        branchCoverage.put(5, false); // Branch 5: End of loop, arrays are equal
    }

    public static void reset(){
        branchCoverage.put(1, false);
        branchCoverage.put(2, false);
        branchCoverage.put(3, false);
        branchCoverage.put(4, false);
        branchCoverage.put(5, false);
        branchCoverage.put(6, false);
        branchCoverage.put(7, false);
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

    public static void printCoveragePercentage() {
        int totalTests = 7;
        int coveredBranches = 0;

        for (boolean hit : branchCoverage.values()) {
            if (hit) {
                coveredBranches++;
            }
        }

        double coveragePercentage = (double) coveredBranches / totalTests * 100;
        totalCoverage += coveragePercentage;

        System.out.printf("Coverage Percentage current Branch: %.2f%%%n", coveragePercentage);
        System.out.printf("Coverage Percentage Total: %.2f%%%n", totalCoverage);
        reset();
    }
}
