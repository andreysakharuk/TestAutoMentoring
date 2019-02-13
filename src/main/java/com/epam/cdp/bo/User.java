package com.epam.cdp.bo;

import com.epam.cdp.base.ConfigProvider;

public class User {

    private String username;
    private String password;

    public User(){
        username = new ConfigProvider().getUsername();
        password = new ConfigProvider().getPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
