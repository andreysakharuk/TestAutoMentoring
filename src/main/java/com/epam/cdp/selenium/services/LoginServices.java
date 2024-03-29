package com.epam.cdp.selenium.services;

import com.epam.cdp.bo.User;
import com.epam.cdp.logging.CrLogger;
import com.epam.cdp.selenium.endtoend.BasePage;

public class LoginServices {

    /**
     * Login with determined credentials
     *
     * @param user credentials for login
     */

    public void doLogin(User user){
        CrLogger.info("Logging in with credentials: " + user.getUsername() + " / " + user.getPassword());
        new BasePage().clickSignInButton()
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickSignInButton();
    }
}

