package com.joshualeepenn.locations.united_states;

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
                State.getStateByNameOrAbbreviation("Fl"),
                State.FL
        );
        sa.assertEquals(
                State.getStateByNameOrAbbreviation("oh"),
                State.OH
        );
        sa.assertEquals(
                State.getStateByNameOrAbbreviation("California"),
                State.CA
        );
        sa.assertEquals(
                State.getStateByNameOrAbbreviation("MISSOURI"),
                State.MO
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
        sa.assertEquals(
                State.getStateByFipsCode(4L),
                State.AZ,
                "Get state by FIPS Code Long Failure"
        );

        double d = 5.1;
        sa.assertEquals(
                State.getStateByFipsCode(d),
                State.AR,
                "Get state by FIPS Code Double Failure"
        );

        float f = 6.2F;
        sa.assertEquals(
                State.getStateByFipsCode(f),
                State.CA,
                "Get state by FIPS Code Float Failure"
        );
        sa.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No state with fips code \"99\" found")
    public void getStateByFipsCodeDoesNotExistTest() {
        State.getStateByFipsCode("99");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "fipsCode String must be a number")
    public void getStateByFipsCodeStringNotANumberTest() {
        State.getStateByFipsCode("fff");
    }

    @Test(expectedExceptions = ClassCastException.class,
            expectedExceptionsMessageRegExp = "fipsCode must be a number express as a String or a Number")
    public void getStateByFipsCodeStringNotAStringOrIntegerTest() {
        Object o = new Object();
        State.getStateByFipsCode(o);
    }

    @Test
    public void getStateByCapitalTest()
    {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(
                State.getStateByCapital("Richmond"),
                State.VA
        );
        sa.assertEquals(
                State.getStateByCapital("WASHINGTON"),
                State.DC
        );
        sa.assertEquals(
                State.getStateByCapital("honolulu"),
                State.HI
        );
        sa.assertEquals(
                State.getStateByCapital(null),
                State.HI
        );
        sa.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No state with capital \"Pittsburgh\" found")
    public void getStateByCapitalNotFoundTest() {
        State.getStateByCapital("Pittsburgh");
    }

    @Test(expectedExceptions = NullPointerException.class,
            expectedExceptionsMessageRegExp = "Capital cannot be null")
    public void getStateByCapitalNullTest() {
        State.getStateByCapital(null);
    }
}
