package com.shyslav.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shyslav on 9/13/16.
 */
public class PasswordValidations {
    private static final int MIN_PASS_LENGTH = 3;
    private static final int MAX_PASS_LENGTH = 20;

    public static boolean validate(String str1, String str2) {
        if (!equestlsValidation(str1, str2)) {
            return false;
        }
        if (!lengthValidation(str1, str2)) {
            return false;
        }
//        if (!validatePattern(str1)) {
//            return false;
//        }
        return true;
    }

    private static boolean equestlsValidation(String str1, String str2) {
        return str1.equals(str2);
    }

    private static boolean lengthValidation(String str1, String str2) {
        if (str1.length() <= MIN_PASS_LENGTH || str2.length() <= MIN_PASS_LENGTH) {
            return false;
        }
        if (str1.length() > MAX_PASS_LENGTH || str2.length() > MAX_PASS_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean validatePattern(String password) {
        Pattern p = Pattern.compile("^\\d*");
        Matcher m = p.matcher(password);
        return m.matches();
    }

}
