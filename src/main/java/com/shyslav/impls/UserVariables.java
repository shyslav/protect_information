package com.shyslav.impls;

/**
 * Created by shyslav on 9/10/16.
 */
public abstract class UserVariables {
    /**
     * Number of incorrect password attempts
     */
    public final int AMOUN_WRONK_PASSWORD_ATTEMPTS = 3;
    /**
     * Block minutes to login page if user entered incorrect password
     */
    public final int WRONG_ATTEMPTS_TIME_SAVE = 30;
}
