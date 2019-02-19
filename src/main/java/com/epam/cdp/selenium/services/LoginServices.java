package com.epam.cdp.selenium.services;

import com.epam.cdp.bo.User;
import com.epam.cdp.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginServices {

    /**
     * Login with valid credentials
     * @param driver WebDriver
     * @param user valid credentials
     */
    public void doLogin(WebDriver driver, User user){
        new BasePage(driver).clickSignInButton()
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickSignInButton();
    }
}

