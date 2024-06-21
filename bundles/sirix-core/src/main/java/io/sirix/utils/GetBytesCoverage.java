package io.sirix.utils;

import java.util.HashMap;
import java.util.Map;

public class GetBytesCoverage {
    public static HashMap<String, Boolean> branchCoverage;

    static {
        branchCoverage = new HashMap<>();
        branchCoverage.put("mValue_true", false);
        branchCoverage.put("mValue_false", false);
    }
}
