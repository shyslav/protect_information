package com.shyslav.data;

import com.shyslav.models.User;

/**
 * Created by shyslav on 9/10/16.
 */
public class UserStorage {
    private String ipAddress;
    private int amounLogin;
    private User user;

    public UserStorage(String ipAddress, int amounLogin, User user) {
        this.ipAddress = ipAddress;
        this.amounLogin = amounLogin;
        this.user = user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getAmounLogin() {
        return amounLogin;
    }

    public void setAmounLogin(int amounLogin) {
        this.amounLogin = amounLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
