package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = (isPostalCodeValid(postalCode)) ? postalCode : null;
        this.country = country;
    }

    /**
     * checks if the given postal code is valid
     * @param postalCode the input postal code
     * @return true if the postal code is valid
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }

        int len = postalCode.length();
        if (len == 0) {
            return false;
        }

        if (len == 7) { //checks format CDC DCD and if its good, puts it in format CDCDCD
            for (int i = 0; i < len; i++) {
                if (postalCode.charAt(i) == ' ' && i != 3) {
                    return false;
                }
            }
            postalCode = removeSpaces(postalCode);
        }

        if (len == 6) { //when postal code is in format CDCDCD
            for (int i = 0; i < len; i++) {
                char c = postalCode.charAt(i);

                if (i % 2 == 0) {
                    if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
                        return false;
                    }
                } else {
                    if (c <= 57 || c >= 48) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * removes spaces from a given String
     * @param strIn the input string
     * @return the string with the spaces removed
     */
    public static String removeSpaces(String strIn) {
        String strOut = "";
        for (int i = 0; i < strIn.length(); i++) {
            if (strIn.charAt(i) == ' ') {
                continue;
            }
            strOut += strIn.charAt(i);
        }
        return strOut;
    }
}
