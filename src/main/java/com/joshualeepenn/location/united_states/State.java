package com.joshualeepenn.location.united_states;

import com.joshualeepenn.constants.Whitespace;

/**
 * States of The United States of America.
 */
public enum State {
    /* States */
    AL("Alabama", 1, "Montgomery"),
    AK("Alaska", 2, "Juneau"),
    AZ("Arizona", 4, "Phoenix"),
    AR("Arkansas", 5, "Little Rock"),
    CA("California", 6, "Sacramento"),
    CO("Colorado", 8, "Denver"),
    CT("Connecticut", 9, "Hartford"),
    DE("Delaware", 10, "Dover"),
    FL("Florida", 12, "Tallahassee"),
    GA("Georgia", 13, "Atlanta"),
    HI("Hawaii", 15, "Honolulu"),
    ID("Idaho", 16, "Boise"),
    IL("Illinois", 17, "Springfield"),
    IN("Indiana", 18, "Indianapolis"),
    IA("Iowa", 19, "Des Moines"),
    KA("Kansas", 20, "Topeka"),
    KY("Kentucky", 21, "Frankfort"),
    LA("Louisiana", 22, "Baton Rouge"),
    ME("Maine", 23, "Augusta"),
    MD("Maryland", 24, "Annapolis"),
    MA("Massachusetts", 25, "Boston"),
    MI("Michigan", 26, "Lansing"),
    MN("Minnesota", 27, "Saint Paul"),
    MS("Mississippi", 28, "Jackson"),
    MO("Missouri", 29, "Jefferson City"),
    MT("Montana", 30, "Helena"),
    NE("Nebraska", 31, "Lincoln"),
    NV("Nevada", 32, "Carson City"),
    NH("New Hampshire", 33, "Concord"),
    NJ("New Jersey", 34, "Trenton"),
    NM("New Mexico", 35, "Santa Fe"),
    NY("New York", 36, "Albany"),
    NC("North Carolina", 37, "Raleigh"),
    ND("North Dakota", 38, "Bismarck"),
    OH("Ohio", 39, "Columbus"),
    OK("Oklahoma", 40, "Oklahoma City"),
    OR("Oregon", 41, "Salem"),
    PA("Pennsylvania", 42, "Harrisburg"),
    RI("Rhode Island", 44, "Providence"),
    SC("South Carolina", 45, "Columbia"),
    SD("South Dakota", 46, "Pierre"),
    TN("Tennessee", 47, "Nashville"),
    TX("Texas", 48, "Austin"),
    UT("Utah", 49, "Salt Lake City"),
    VT("Vermont", 50, "Montpelier"),
    VA("Virginia", 51, "Richmond"),
    WA("Washington", 53, "Olympia"),
    WV("West Virginia", 54, "Charleston"),
    WI("Wisconsin", 55, "Madison"),

    /* Federal District */
    DC("District of Columbia", 11, "Washington"),

    /* Territories */
    WY("Wyoming", 56, "Cheyenne"),
    AS("American Samoa", 60, "Pago Pago"),
    FM("Federated States of Micronesia", 64, "Palikir"),
    GU("Guam", 66, "Hagatna"),
    MH("Marshall Islands", 68, "Majuro"),
    MP("Northern Mariana Islands", 59, "Saipan"),
    PW("Palau", 70, "Ngerulmud"),
    PR("Puerto Rico", 72, "San Juan"),
    UM("U.S. Minor Outlying Islands", 74, Whitespace.EMPTY),
    VI("U.S. Virgin Islands", 78, "Charlotte Amalie");

    private final String name;
    private final int fipsCodeInteger;
    private final String capital;

    State(String name, int fipsCodeInteger, String capital) {
        this.name = name;
        this.fipsCodeInteger = fipsCodeInteger;
        this.capital = capital;
    }

    /**
     * Get the name of the state.
     *
     * @return The nameof the state.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the 2-character FIPS code as a String.
     *
     * @return The FIPS code.
     */
    public String getFipsCode() {
        return String.format("%02d", fipsCodeInteger);
    }

    /**
     * Get the integer value of the FIPS code.
     *
     * @return The FIPS code as an integer.
     */
    public int getFipsCodeAsInteger() {
        return fipsCodeInteger;
    }

    /**
     * Get the state's postal abbreviation.
     *
     * @return The abbreviation.
     */
    public String getAbbreviation() {
        return this.name();
    }

    /**
     * Get the state's capital.
     *
     * @return The capital.
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Get the state by name or abbreviation. Ignores case.
     *
     * @param nameOrAbbreviation The state's name or abbreviation.
     * @return The state.
     */
    public static State getStateByNameOrAbbreviation(String nameOrAbbreviation) {
        if (nameOrAbbreviation.length() == 2)
            return getStateByAbbreviation(nameOrAbbreviation);
        return getStateByName(nameOrAbbreviation);
    }

    /**
     * Get the state by name. Ignores case.
     *
     * @param name The state's name.
     * @return The state.
     */
    public static State getStateByName(String name) {
        for (State state : State.values())
            if (state.getName().equalsIgnoreCase(name))
                return state;

        throw new IllegalArgumentException("No state with name \"" + name + "\" found");
    }

    /**
     * Get the state by abbreviation. Ignores case.
     *
     * @param abbreviation The state's abbreviation.
     * @return The state.
     */
    public static State getStateByAbbreviation(String abbreviation) {
        for (State state : State.values())
            if (state.getAbbreviation().equalsIgnoreCase(abbreviation))
                return state;

        throw new IllegalArgumentException("No state with abbreviation \"" + abbreviation + "\" found");
    }

    /**
     * Get the state by FIPS code.
     *
     * @param fipsCode The FIPS Code, as a Number or String type.
     * @return The state.
     */
    public static <T> State getStateByFipsCode(T fipsCode) {
        int fipsCodeInteger;

        if (Number.class.isAssignableFrom(fipsCode.getClass())) {
            fipsCodeInteger = ((Number) fipsCode).intValue();
        } else if (fipsCode.getClass() == String.class) {
            try {
                fipsCodeInteger = Integer.parseInt((String) fipsCode);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("fipsCode String must be a number");
            }
        }
        else
            throw new ClassCastException("fipsCode must be a number express as a String or a Number");

        for (State state : State.values())
            if (state.fipsCodeInteger == fipsCodeInteger)
                return state;
        throw new IllegalArgumentException("No state with fips code \"" + fipsCode + "\" found");
    }

    /**
     * Get the state by capital.
     *
     * @param capital The capital of the state.
     * @return The state.
     */
    public static State getStateByCapital(String capital) {
        if (null == capital)
            throw new NullPointerException("Capital cannot be null");
        for (State state : State.values())
            if (capital.equalsIgnoreCase(state.getCapital()))
                return state;
        throw new IllegalArgumentException("No state with capital \"" + capital + "\" found");
    }
}
