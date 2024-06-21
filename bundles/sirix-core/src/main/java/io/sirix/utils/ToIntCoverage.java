package io.sirix.utils;

import java.util.HashMap;

public class ToIntCoverage {
    public static HashMap<String, Boolean> branchCoverage;
    static {
        branchCoverage = new HashMap<>();
        branchCoverage.put("first_if_statement", false);
        branchCoverage.put("second_if_statement", false);
        branchCoverage.put("third_if_statement", false);
        branchCoverage.put("else_statement", false);
    }
}
