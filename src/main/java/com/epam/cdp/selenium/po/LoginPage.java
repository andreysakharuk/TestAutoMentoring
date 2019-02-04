package com.epam.cdp.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class LoginPage extends AbstractPage {

    private final By usernameInputLocator = By.name("userName");
    private final By passwordInputLocator = By.name("password");
    private final By signInButtonLocator = By.cssSelector("div.gnav-sign-in__form__submit input");


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

    public <T extends AbstractPage> T clickSignInButton(Class<T> pageClass) {
        driver.findElement(signInButtonLocator).click();
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);

        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create page!");
        }
    }

    public boolean isSignInButtonDisplayed() {
        return driver.findElement(signInButtonLocator).isDisplayed();
    }
}