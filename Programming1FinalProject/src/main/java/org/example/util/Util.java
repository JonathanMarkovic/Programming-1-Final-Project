package org.example.util;

public class Util {

    /**
     * converts a given string to titlecase
     * @param strIn the input string
     * @return the string in titlecase
     */
    public static String toTitleCase(String strIn) {
        String strOut = "";
        String[] strIns = strIn.split(" ");
        for (String str : strIns) {
            String first = str.substring(0,1).toUpperCase();
            String second = str.substring(1).toLowerCase();
            String combined = first + second;
            strOut += combined + " ";
        }
        return strOut.trim();
    }

}
