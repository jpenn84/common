package com.joshualeepenn.utilities;

import java.util.Arrays;
import java.util.List;

import static com.joshualeepenn.constants.Separator.COMMA;
import static com.joshualeepenn.constants.Whitespace.SPACE;

public class DelimitedString {

    public static List<String> delimitedStringToList(String string) {
        return delimitedStringToList(string, COMMA);
    }

    public static List<String> delimitedStringToList(String string, String separator) {
        return Arrays.stream(string.split(separator)).map(String::trim).toList();
    }

    public static String listToDelimitedString(List<String> list, boolean spaceAfterSeparator) {
        return listToDelimitedString(list, COMMA, spaceAfterSeparator);
    }

    public static String listToDelimitedString(List<String> list, String separator, boolean spaceAfterDelimiter) {
        return String.join(spaceAfterDelimiter ? separator + SPACE : separator, list).trim();
    }
}
