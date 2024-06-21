package io.sirix.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Arrays;

public class BranchCoverageTest {
    private static double totalCoverage = 0.0;

    @Test
    public void testGetBytesTrue() {
        System.out.println("----------");
        byte[] result = TypedValue.getBytes(true);
        boolean coverageValue1 = GetBytesCoverage.branchCoverage.get("mValue_false");
        boolean coverageValue2 = GetBytesCoverage.branchCoverage.get("mValue_true");

        System.out.println("Input value True");
        printCoverageValues(coverageValue1, coverageValue2);
        printResultAndExpected(result, new byte[] {1});

        assertArrayEquals(new byte[] {1}, result);
    }

    @Test
    public void testGetBytesFalse() {
        System.out.println("----------");
        byte[] result = TypedValue.getBytes(false);
        boolean coverageValue1 = GetBytesCoverage.branchCoverage.get("mValue_false");
        boolean coverageValue2 = GetBytesCoverage.branchCoverage.get("mValue_true");

        System.out.println("Input value False");
        printCoverageValues(coverageValue1, coverageValue2);
        printResultAndExpected(result, new byte[] {0});

        assertArrayEquals(new byte[] {0}, result);
    }

    private void printCoverageValues(boolean value1, boolean value2) {
        System.out.printf("Coverage Value for mValue_false is: %b \n", value1);
        System.out.printf("Coverage Value for mValue_true is: %b \n", value2);
    }

    private void printResultAndExpected(byte[] result, byte[] expected) {
        String resultString = Arrays.toString(result);
        String expectedString = Arrays.toString(expected);
        System.out.printf("Result: %s \n", resultString);
        System.out.printf("Expected: %s \n", expectedString);
        printCoveragePercentage();
        resetCoverageValues();
    }

    private void printCoveragePercentage() {
        int totalTests = 2;

        int coveredBranches = 0;
        if (GetBytesCoverage.branchCoverage.get("mValue_true")) {
            coveredBranches++;
        }
        if (GetBytesCoverage.branchCoverage.get("mValue_false")) {
            coveredBranches++;
        }
        double coveragePercentage = (double) coveredBranches / totalTests * 100;
        totalCoverage += coveragePercentage;
        System.out.printf("Coverage Percentage current Branch: %.2f%%\n", coveragePercentage);
        System.out.printf("Coverage Percentage Total: %.2f%% \n", totalCoverage);
    }

    private void resetCoverageValues() {
        GetBytesCoverage.branchCoverage.put("mValue_true", false);
        GetBytesCoverage.branchCoverage.put("mValue_false", false);
    }
}
