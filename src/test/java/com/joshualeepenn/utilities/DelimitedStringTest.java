package com.joshualeepenn.utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.joshualeepenn.constants.Separator.COLON;
import static com.joshualeepenn.constants.Separator.COMMA;
import static com.joshualeepenn.constants.Whitespace.SPACE;
import static com.joshualeepenn.constants.Whitespace.TAB;

public class DelimitedStringTest {

    private static final String CLEAR = "clear";
    private static final String PURPLE = "purple";
    private static final String SILVER = "silver";
    private static final String RED = "red";


    private static final String TEST_STRING_1 = CLEAR + SPACE + COMMA + PURPLE + COMMA + TAB + SILVER + COMMA + RED;
    private static final String TEST_STRING_2 = CLEAR + SPACE + COLON + PURPLE + COLON + TAB + SILVER + COLON + RED;
    private final List<String> testList1 = new ArrayList<>();

    @BeforeTest
    public void setUp() {
        testList1.add(CLEAR);
        testList1.add(PURPLE);
        testList1.add(SILVER);
        testList1.add(RED);
    }

    @Test
    public void testDelimitedStringToList() {
        List<String> actualResult = DelimitedString.delimitedStringToList(TEST_STRING_1);
        Assert.assertEquals(actualResult, testList1);
    }

    @Test
    public void testDelimitedStringToListWithSeparatorParam() {
        List<String> actualResult = DelimitedString.delimitedStringToList(TEST_STRING_2, COLON);
        Assert.assertEquals(actualResult, testList1);
    }

    @Test
    public void testListToDelimitedStringNoSpace() {
        String actualResult = DelimitedString.listToDelimitedString(testList1, false);
        String expectedResult = CLEAR + COMMA + PURPLE + COMMA + SILVER + COMMA + RED;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testListToDelimitedStringWithSpace() {
        String actualResult = DelimitedString.listToDelimitedString(testList1, true);
        String expectedResult = CLEAR + COMMA + SPACE + PURPLE + COMMA + SPACE + SILVER + COMMA + SPACE + RED;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testListToDelimitedStringNoSpaceTabDelimited() {
        String actualResult = DelimitedString.listToDelimitedString(testList1, TAB, false);
        String expectedResult = CLEAR + TAB + PURPLE + TAB + SILVER + TAB + RED;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testListToDelimitedStringWithSpaceTabDelimited() {
        String actualResult = DelimitedString.listToDelimitedString(testList1, TAB, true);
        String expectedResult = CLEAR + TAB + SPACE + PURPLE + TAB + SPACE + SILVER + TAB + SPACE + RED;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
