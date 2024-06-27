package io.sirix.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BranchCoverageToIntTest {
    private static double totalCoverage = 0.0;
    @Test
    public void testSingleByteConversion() {
        System.out.println("----------");
        byte[] bytes = {0x7F};
        int result = Calc.toInt(bytes, 0, 1);
        System.out.println("Input value: length is 1");
        getCurrentBranchCoverage();
        printCoveragePercentage();
        assertEquals(127, result);
    }

    @Test
    public void testTwoBytesConversion() {
        System.out.println("----------");
        byte[] bytes = {(byte) 0xFF, (byte) 0x7F};
        int result = Calc.toInt(bytes, 0, 2);
        System.out.println("Input value: length is 2");
        getCurrentBranchCoverage();
        printCoveragePercentage();
        assertEquals(65407, result);
    }

    @Test
    public void testThreeBytesConversion() {
        System.out.println("----------");
        byte[] bytes = {(byte) 0xFF, (byte) 0xFF, (byte) 0x7F};
        int result = Calc.toInt(bytes, 0, 3);
        System.out.println("Input value: length is 3");
        getCurrentBranchCoverage();
        printCoveragePercentage();
        assertEquals(16777087, result);
    }

    @Test
    public void testFourBytesConversion() {
        System.out.println("----------");
        byte[] bytes = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x7F};
        int result = Calc.toInt(bytes, 0, 4);
        System.out.println("Input value: length is 4");
        getCurrentBranchCoverage();
        printCoveragePercentage();
        assertEquals(-129, result);
    }

    private void getCurrentBranchCoverage() {
        boolean coverageValue1 = ToIntCoverage.branchCoverage.get("first_if_statement");
        boolean coverageValue2 = ToIntCoverage.branchCoverage.get("first_invisible_else");
        boolean coverageValue3 = ToIntCoverage.branchCoverage.get("second_if_statement");
        boolean coverageValue4 = ToIntCoverage.branchCoverage.get("second_invisible_else");
        boolean coverageValue5 = ToIntCoverage.branchCoverage.get("third_if_statement");
        boolean coverageValue6 = ToIntCoverage.branchCoverage.get("visible_else_statement");

        printCoverageValues(coverageValue1, coverageValue2, coverageValue3, coverageValue4,
                            coverageValue5, coverageValue6);
    }

    private void printCoverageValues(boolean value1, boolean value2, boolean value3, boolean value4,
                                     boolean value5, boolean value6) {
        System.out.printf("Coverage Value for first_if_statement is: %b \n", value1);
        System.out.printf("Coverage Value for first_invisible_else is: %b \n", value2);
        System.out.printf("Coverage Value for second_if_statement is: %b \n", value3);
        System.out.printf("Coverage Value for second_invisible_else is: %b \n", value4);
        System.out.printf("Coverage Value for third_if_statement is: %b \n", value5);
        System.out.printf("Coverage Value for visible_else_statement is: %b \n", value6);
    }
    private void printCoveragePercentage() {
        int totalTests = 4;

        int coveredBranches = 0;
        if (ToIntCoverage.branchCoverage.get("first_if_statement")) {
            coveredBranches++;
        }
        if (ToIntCoverage.branchCoverage.get("second_if_statement")) {
            coveredBranches++;
        }
        if (ToIntCoverage.branchCoverage.get("third_if_statement")) {
            coveredBranches++;
        }
        if (ToIntCoverage.branchCoverage.get("visible_else_statement")) {
            coveredBranches++;
        }
        double coveragePercentage = (double) coveredBranches / totalTests * 100;
        totalCoverage += coveragePercentage;
        System.out.printf("Coverage Percentage current Branch: %.2f%%\n", coveragePercentage);
        System.out.printf("Coverage Percentage Total: %.2f%% \n", totalCoverage);
        resetCoverageValues();
    }

    private void resetCoverageValues() {
        ToIntCoverage.branchCoverage.put("first_if_statement", false);
        ToIntCoverage.branchCoverage.put("first_invisible_else", false);
        ToIntCoverage.branchCoverage.put("second_if_statement", false);
        ToIntCoverage.branchCoverage.put("second_invisible_else", false);
        ToIntCoverage.branchCoverage.put("third_if_statement", false);
        ToIntCoverage.branchCoverage.put("visible_else_statement", false);
    }
}
