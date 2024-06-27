package com.joshualeepenn.location.united_states;

/**
 * States of The United States of America.
 */
public enum State {
    AL("Alabama", 1),
    AK("Alaska", 2),
    AZ("Arizona", 4),
    AR("Arkansas", 5),
    CA("California", 6),
    CO("Colorado", 8),
    CT("Connecticut", 9),
    DE("Delaware", 10),
    DC("District of Columbia", 11),
    FL("Florida", 12),
    GA("Georgia", 13),
    HI("Hawaii", 15),
    ID("Idaho", 16),
    IL("Illinois", 17),
    IN("Indiana", 18),
    IA("Iowa", 19),
    KA("Kansas", 20),
    KY("Kentucky", 21),
    LA("Louisiana", 22),
    ME("Maine", 23),
    MD("Maryland", 24),
    MA("Massachusetts", 25),
    MI("Michigan", 26),
    MN("Minnesota", 27),
    MS("Mississippi", 28),
    MO("Missouri", 29),
    MT("Montana", 30),
    NE("Nebraska", 31),
    NV("Nevada", 32),
    NH("New Hampshire", 33),
    NJ("New Jersey", 34),
    NM("New Mexico", 35),
    NY("New York", 36),
    NC("North Carolina", 37),
    ND("North Dakota", 38),
    OH("Ohio", 39),
    OK("Oklahoma", 40),
    OR("Oregon", 41),
    PA("Pennsylvania", 42),
    RI("Rhode Island", 44),
    SC("South Carolina", 45),
    SD("South Dakota", 46),
    TN("Tennessee", 47),
    TX("Texas", 48),
    UT("Utah", 49),
    VT("Vermont", 50),
    VA("Virginia", 51),
    WA("Washington", 53),
    WV("West Virginia", 54),
    WI("Wisconsin", 55),
    WY("Wyoming", 56);

    private final String name;
    private final int fipsCodeInteger;

    State(String name, int fipsCodeInteger) {
        this.name = name;
        this.fipsCodeInteger = fipsCodeInteger;
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
     * @return The Abbreviation.
     */
    public String getAbbreviation() {
        return this.name();
    }

    /**
     * Get the state by name or abbreviation. Ignores case.
     *
     * @param nameOrAbbreviation The state's name or abbreviation.
     * @return The State.
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
     * @return The State.
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
     * @return The State.
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
     * @param fipsCode The FIPS Code, as an Integer or String type.
     * @return The State.
     */
    public static <T> State getStateByFipsCode(T fipsCode) {
        int fipsCodeInteger;

        if (fipsCode.getClass().equals(Integer.class)) {
            fipsCodeInteger = (Integer) fipsCode;
        } else if (fipsCode.getClass() == String.class) {
            try {
                fipsCodeInteger = Integer.parseInt((String) fipsCode);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("fipsCode String must be a number");
            }
        }
        else
            throw new ClassCastException("fipsCode must be a number express as a String or an integer");

        for (State state : State.values())
            if (state.fipsCodeInteger == fipsCodeInteger)
                return state;
        throw new IllegalArgumentException("No state with fips code \"" + fipsCode + "\" found");
    }
}
