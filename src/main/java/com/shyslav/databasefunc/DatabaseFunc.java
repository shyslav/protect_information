package com.shyslav.databasefunc;

import database.updateCommand.UpdateCommand;

/**
 * Created by shyslav on 9/13/16.
 */
public class DatabaseFunc {
    public static boolean blockUser(int userID) {
        UpdateCommand.updateTable("user", new String[]{"role=3"}, new String[]{"id = " + userID});
        return true;
    }

    public static boolean unBlockUser(int userID) {
        UpdateCommand.updateTable("user", new String[]{"role=2"}, new String[]{"id = " + userID});
        return true;
    }
}
