package io.sirix.utils;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void compareUAsPrefix(){
        byte[] value1 = new byte[]{2, 2, 2,2};
        assertEquals("Null, which should be maximum value, is smaller that non null.", -1, Calc.compareUAsPrefix(value1, null));
        assertEquals("Null, which should be maximum value, is smaller that non null.", 1, Calc.compareUAsPrefix(null, value1));
        assertEquals("Both are the largest possible value and thus equal.", 0, Calc.compareUAsPrefix(null, null));
        byte[] value2 = new byte[]{1, 1, 1, 1};
        assertEquals("Comparison where the first value is larger than the second gave error.", 1, Calc.compareUAsPrefix(value1, value2));
        byte[] value3 = new byte[]{2, 2, 2, 2, 2};
        assertEquals("Comparison where one is longer than the other gave the incorrect result", 1, Calc.compareUAsPrefix(value3, value1));
    }

    @Test
    public void compareAsPrefix(){
        byte[] value1 = new byte[]{2, 2, 2,2};
        assertEquals("Null, which should be maximum value, is smaller that non null.", -1, Calc.compareAsPrefix(value1, null));
        assertEquals("Null, which should be maximum value, is smaller that non null.", 1, Calc.compareAsPrefix(null, value1));
        assertEquals("Both are the largest possible value and thus equal.", 0, Calc.compareAsPrefix(null, null));
        byte[] value2 = new byte[]{1, 1, 1, 1};
        assertEquals("Comparison where the first value is larger than the second gave error.", 1, Calc.compareAsPrefix(value1, value2));
        byte[] value3 = new byte[]{2, 2, 2, 2, 2};
        assertEquals("Comparison where one is longer than the other gave the incorrect result", 1, Calc.compareAsPrefix(value3, value1));
    }

    @Test
    public void compareInt(){
        byte[] value1 = new byte[]{1, 1, 1, 1};
        byte[] value2 = new byte[]{1, 1, 1, 2,};
        assertEquals("The second value should be 1 larger than the first", -1, Calc.compareInt(value1, value2));
    }

    @Test
    public void compareLong(){
        byte[] value1 = new byte[]{1, 1, 1, 1, 1, 1, 1, 1};
        byte[] value2 = new byte[]{1, 1, 1, 1, 1, 1, 1, 2};
        assertEquals("The second value value should be 1 larger than the first", -1, Calc.compareLong(value1, value2));
    }

    @Test
    public void testFirstIfNullCheck() {
        byte[] nullArray = null;
        try {
            Calc.toUIntVar(nullArray);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Input byte array cannot be null", e.getMessage());
            ToUIntVarCoverageTool.printCoverage();
        }
    }

    @Test
    public void testSecondIfLengthOne() {
        byte[] byteArray = new byte[] { 0x7F };
        int result = Calc.toUIntVar(byteArray);
        assertEquals(0x7F, result);

        ToUIntVarCoverageTool.printCoverage();
    }

    @Test
    public void testThirdIfLengthTwo() {
        byte[] byteArray = new byte[] { (byte) 0xFE, (byte) 0x01 };
        int result = Calc.toUIntVar(byteArray);
        assertEquals(0xFE01, result);
        ToUIntVarCoverageTool.printCoverage();
    }

    @Test
    public void testFourthIfLengthThree() {
        byte[] byteArray = new byte[] { (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
        int result =  Calc.toUIntVar(byteArray);
        assertEquals(0xABCDEF, result);
        ToUIntVarCoverageTool.printCoverage();
    }

    @Test
    public void testFifthIfLengthGreaterThanThree() {
        byte[] byteArray = new byte[] { (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 };
        int result = Calc.toUIntVar(byteArray);
        assertEquals(0x12345678, result);
        ToUIntVarCoverageTool.printCoverage();
    }

}
