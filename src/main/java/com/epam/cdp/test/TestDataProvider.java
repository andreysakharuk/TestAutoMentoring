package com.epam.cdp.test;

import com.epam.cdp.base.ConfigProvider;
import com.epam.cdp.bo.User;

public class TestDataProvider {

    public static User getValidUser() {
        User user = new User();
        user.setUsername(new ConfigProvider().getUsername());
        user.setPassword(new ConfigProvider().getPassword());
        return user;
    }
}

