package com.shyslav.validations;

import database.configuration.DatabaseConnection;
import database.insert.DatabaseInsert;
import lazydata.LazyDate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shyslav on 9/10/16.
 */
public abstract class DatabaseValidations {
    private static DatabaseConnection db = new DatabaseConnection();

    public static boolean checkUser(String login, String password, String ip) {
        try {
            PreparedStatement preparedStatement =
                    db.getConnection().prepareStatement("SELECT * FROM user WHERE login = ? AND password = md5(?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                DatabaseInsert.prepareInsert("login_data",
                        new Object[]{login, "-", LazyDate.getUnixDate(), ip, "success"},
                        new String[]{"login", "password", "login_time", "ip", "status"});
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        DatabaseInsert.prepareInsert("login_data",
                new Object[]{login, password, (int) System.currentTimeMillis() / 1000, ip, "error"},
                new String[]{"login", "password", "login_time", "ip", "status"});
        return false;
    }
}
