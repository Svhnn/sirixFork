package io.sirix.utils;

import java.util.HashMap;

public class ToIntCoverage {
    public static HashMap<String, Boolean> branchCoverage;
    static {
        branchCoverage = new HashMap<>();
        branchCoverage.put("first_if_statement", false);
        branchCoverage.put("first_invisible_else", false);
        branchCoverage.put("second_if_statement", false);
        branchCoverage.put("second_invisible_else", false);
        branchCoverage.put("third_if_statement", false);
        branchCoverage.put("visible_else_statement", false);
    }
}
