package com.joshualeepenn.utilities;

import com.joshualeepenn.location.united_states.State;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StateTest {

    @Test public void singleDigitFipsCodeTest() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(State.AL.getName(), "Alabama");
        sa.assertEquals(State.AL.getFipsCode(), "01");
        sa.assertEquals(State.AL.getAbbreviation(), "AL");
        sa.assertEquals(State.AL.getFipsCodeAsInteger(), 1);
        sa.assertAll();
    }

    @Test public void doubleDigitFipsCodeTest() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(State.PA.getName(), "Pennsylvania");
        sa.assertEquals(State.PA.getFipsCode(), "42");
        sa.assertEquals(State.PA.getAbbreviation(), "PA");
        sa.assertEquals(State.PA.getFipsCodeAsInteger(), 42);
        sa.assertAll();
    }

    @Test public void getStateByName() {
        Assert.assertEquals(
                State.getStateByName("California"),
                State.CA
        );
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No state with name \"Invalid\" found")
    public void getStateByInvalidName() {
        State.getStateByName("Invalid");
    }

    @Test public void getStateByAbbreviation() {
        Assert.assertEquals(
                State.getStateByAbbreviation("ME"),
                State.ME
        );
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No state with abbreviation \"NA\" found")
    public void getStateByInvalidAbbreviation() {
        State.getStateByAbbreviation("NA");
    }

    @Test public void getStateByNameOrAbbreviationTest() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(
                State.getStateByNameOrAbbreviation("VA"),
                State.VA
        );
        sa.assertEquals(
                State.getStateByNameOrAbbreviation("California"),
                State.CA
        );
        sa.assertAll();
    }

    @Test public void getStateByFipsCodeTest() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(
                State.getStateByFipsCode("01"),
                State.AL,
                "Get state by FIPS Code String Failure"
        );
        sa.assertEquals(
                State.getStateByFipsCode(2),
                State.AK,
                "Get state by FIPS Code Integer Failure"
        );
        sa.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No state with fips code \"99\" found")
    public void getStateByFipsCodeDoesNotExistTest() {
        State.getStateByFipsCode("99");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "fipsCode String must be a number")
    public void getStateByFipsCodeStringNotANumberTest() {
        State.getStateByFipsCode("fff");
    }

    @Test(expectedExceptions = ClassCastException.class,
            expectedExceptionsMessageRegExp = "fipsCode must be a number express as a String or an integer")
    public void getStateByFipsCodeStringNotAStringOrIntegerTest() {
        Object o = new Object();
        State.getStateByFipsCode(o);
    }
}
