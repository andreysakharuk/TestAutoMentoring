package com.epam.cdp.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    private final By signInButton = By.className("gnav-sign-in");

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
}