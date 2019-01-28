package com.epam.cdp.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private final By usernameInputLocator = By.name("userName");
    private final By passwordInputLocator = By.name("password");
    private final By signInButtonInLoginFormLocator = By.cssSelector("div.gnav-sign-in__form__submit input");


    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String query) {
        driver.findElement(usernameInputLocator).sendKeys(query);
        return this;
    }

    public LoginPage enterPassword(String query) {
        driver.findElement(passwordInputLocator).sendKeys(query);
        return this;
    }

    public RatingsFullPage clickSignInButtonInLoginForm() {
        driver.findElement(signInButtonInLoginFormLocator).click();
        return new RatingsFullPage(driver);
    }

    public boolean isSignInButtonDisplayed() {
        waitForElementVisible(signInButtonInLoginFormLocator);
        return driver.findElement(signInButtonInLoginFormLocator).isDisplayed();
    }
}