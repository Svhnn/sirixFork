package io.sirix.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ArrayTests {
    @Test
    public void testIdenticalArrays() {
        Object[] arr1 = {1, "test", 3.14};
        Object[] arr2 = arr1;
        assertTrue(Array.equals(arr1, arr2));
        BranchCoverageArrayTool.printCoverage();
    }

    @Test
    public void testOneArrayNull() {
        Object[] arr1 = {1, "test", 3.14};
        Object[] arr2 = null;
        assertFalse(Array.equals(arr1, arr2));
        assertFalse(Array.equals(arr2, arr1));
        BranchCoverageArrayTool.printCoverage();
    }

    @Test
    public void testBothArraysNull() {
        Object[] arr1 = null;
        Object[] arr2 = null;
        assertTrue(Array.equals(arr1, arr2));
        BranchCoverageArrayTool.printCoverage();
    }

    @Test
    public void testDifferentLengths() {
        Object[] arr1 = {1, "test", 3.14};
        Object[] arr2 = {1, "test"};
        assertFalse(Array.equals(arr1, arr2));
        BranchCoverageArrayTool.printCoverage();
    }

    @Test
    public void testDifferentElements() {
        Object[] arr1 = {1, "test", 3.14};
        Object[] arr2 = {1, "test", 2.71};
        assertFalse(Array.equals(arr1, arr2));
        BranchCoverageArrayTool.printCoverage();
    }

    @Test
    public void testSameElementsDifferentReferences() {
        Object[] arr1 = {1, "test", 3.14};
        Object[] arr2 = {1, "test", 3.14};
        assertTrue(Array.equals(arr1, arr2));
        BranchCoverageArrayTool.printCoverage();
    }
}
