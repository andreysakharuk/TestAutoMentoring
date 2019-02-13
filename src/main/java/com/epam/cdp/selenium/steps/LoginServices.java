package com.epam.cdp.selenium.steps;

import com.epam.cdp.bo.User;
import com.epam.cdp.selenium.pf.BasePage;
import com.epam.cdp.selenium.pf.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginServices {

    public void doLogin(WebDriver driver, User user){
        new BasePage(driver).clickSignInButton();
        new LoginPage(driver).enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickSignInButton();
    }
}

