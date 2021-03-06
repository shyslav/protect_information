package com.shyslav.validations;

import siteentity.storage.UserStorage;
import database.configuration.DatabaseConnection;
import database.insert.DatabaseInsert;
import lazyfunction.LazyDate;
import siteentity.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shyslav on 9/10/16.
 */
public abstract class DatabaseValidations {
    private static DatabaseConnection db = new DatabaseConnection();

    public static boolean checkUser(String login, String password, String ip, UserStorage storage) {
        try {
            PreparedStatement preparedStatement =
                    db.getConnection().prepareStatement("SELECT * FROM user " +
                            "inner join role on role.id = user.role " +
                            "WHERE login = ? AND password = md5(?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name"));
                storage.setUser(user);
                DatabaseInsert.prepareInsert("login_data",
                        new Object[]{login, "-", LazyDate.getUnixDate(), ip, "success"},
                        new String[]{"login", "password", "login_time", "ip", "status"});
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        storage.increase();
        DatabaseInsert.prepareInsert("login_data",
                new Object[]{login, password, LazyDate.getUnixDate(), ip, "error"},
                new String[]{"login", "password", "login_time", "ip", "status"});
        return false;
    }
}
