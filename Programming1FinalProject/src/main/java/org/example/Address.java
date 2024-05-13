package org.example;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

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

        if (len == 6) {
            for (int i = 0; i < len; i++) {
                char c = postalCode.charAt(i);

                if (i % 2 == 0) {
                    if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
                        return false;
                    }
                } else {
                    if (c <= 57 || c  >= 48) {
                        return false;
                    }
                }
            }
        } else if (len == 7) {
            if (postalCode.charAt(3) == ' ') {
                //postalCode = ;
            }
            for (int i = 0; i < len; i ++) {
                char c = postalCode.charAt(i);

            }
        }
        return true;
    }
}
