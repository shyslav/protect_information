package com.shyslav.validations;

/**
 * Created by shyslav on 9/13/16.
 */
public class PasswordValidations {
    private static final int MIN_PASS_LENGTH = 3;

    public static boolean validate(String str1, String str2){
        if(!equestlsValidation(str1,str2)){
            return false;
        }
        if (!lengthValidation(str1,str2)){
            return false;
        }
        return true;
    }

    private static boolean equestlsValidation(String str1, String str2) {
        return str1.equals(str2);
    }

    private static boolean lengthValidation(String str1, String str2) {
        if (str1.length() <= MIN_PASS_LENGTH || str2.length() <= MIN_PASS_LENGTH) {
            return false;
        }
        return true;
    }
}
