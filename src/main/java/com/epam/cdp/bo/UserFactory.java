package com.epam.cdp.bo;

import com.epam.cdp.base.ConfigProvider;

public class UserFactory {

    public static User getValidUser() {
        User user = new User();
        user.setUsername(new ConfigProvider().getUsername());
        user.setPassword(new ConfigProvider().getPassword());
        return user;
    }

    public static User createUserInvalidPassword(){
        User user = new User();
        user.setUsername(new ConfigProvider().getUsername());
        user.setPassword(new ConfigProvider().getInvalidPassword());
        return user;
    }

    public static User createUserInvalidUsername(){
        User user = new User();
        user.setUsername(new ConfigProvider().getInvalidUsername());
        user.setPassword(new ConfigProvider().getPassword());
        return user;
    }
}

