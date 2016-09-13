package com.shyslav.models;

import database.configuration.DatabaseConnection;
import siteentity.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shyslav on 9/11/16.
 */
public class UserList extends ArrayList<User> {
    HashMap<Integer, User> map;

    public UserList() {
        this.map = new HashMap<Integer, User>();
        selectUserList();
    }

    public void getByID(int id) {
        map.get(id);
    }

    private void selectUserList() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = "select user.id,user.login,role.name from user inner join role on user.role = role.id";
        try {
            PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                map.put(rs.getInt("id"), new User(rs.getInt("id"), rs.getString("login"), rs.getString("name")));
                super.add(map.get(map.size()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
