package com.joshualeepenn.utilities;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IntegerToolsTest {

    @Test
    public void getOrdinalTest() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(IntegerTools.getOrdinal(1), "1st");
        sa.assertEquals(IntegerTools.getOrdinal(2), "2nd");
        sa.assertEquals(IntegerTools.getOrdinal(3), "3rd");
        sa.assertEquals(IntegerTools.getOrdinal(4), "4th");
        sa.assertEquals(IntegerTools.getOrdinal(5), "5th");
        sa.assertEquals(IntegerTools.getOrdinal(6), "6th");
        sa.assertEquals(IntegerTools.getOrdinal(7), "7th");
        sa.assertEquals(IntegerTools.getOrdinal(8), "8th");
        sa.assertEquals(IntegerTools.getOrdinal(9), "9th");
        sa.assertEquals(IntegerTools.getOrdinal(10), "10th");
        sa.assertEquals(IntegerTools.getOrdinal(117453), "117453rd");
        sa.assertEquals(IntegerTools.getOrdinal(-1), "-1st");
        sa.assertAll();
    }

}
