package com.joshualeepenn.utilities;

import com.joshualeepenn.symbols.Ordinal;

public class IntegerTools {

    public static String getOrdinal(int i) {
        String input = Integer.toString(i);
        return switch (input.substring(input.length() - 1)) {
            case "1" -> input + Ordinal.ST;
            case "2" -> input + Ordinal.ND;
            case "3" -> input + Ordinal.RD;
            default -> input + Ordinal.TH;
        };
    }

}
