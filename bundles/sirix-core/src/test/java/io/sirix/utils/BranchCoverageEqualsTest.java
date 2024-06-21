package io.sirix.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BranchCoverageEqualsTest {
    @Test
    public void testOneIsNull(){
        byte[] value1 = "test".getBytes();
        byte[] value2 = null;

        boolean result = TypedValue.equals(value1, value2);

        assertFalse(result);
        EqualsCoverageTool.printCoverage();
    }

    @Test
    public void testUnequalLengths() {
        byte[] value1 = "test".getBytes();
        byte[] value2 = "testing".getBytes(); // Different length

        boolean result = TypedValue.equals(value1, value2);

        assertFalse(result);
        EqualsCoverageTool.printCoverage();
    }

    @Test
    public void testSingleByteMismatch() {
        byte[] value1 = "test".getBytes();
        byte[] value2 = "tEst".getBytes(); // 'E' vs 'e' mismatch

        boolean result = TypedValue.equals(value1, value2);

        assertFalse(result);
        EqualsCoverageTool.printCoverage();
    }

    @Test
    public void testEqualWords() {
        byte[] value1 = "test".getBytes();
        byte[] value2 = "test".getBytes();

        boolean result = TypedValue.equals(value1, value2);

        assertTrue(result);
        EqualsCoverageTool.printCoverage();
    }
}
