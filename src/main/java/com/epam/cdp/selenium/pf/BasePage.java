package com.epam.cdp.selenium.pf;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

public class BasePage extends AbstractPage {

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButton;

    @FindBy(css = ".footer-logo")
    private WebElement crLogo;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public <T extends RatingsPage> T generatePage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create page!");
        }
    }

    public LoginPage clickSignInButton() {
        waitForElementVisible(signInButton);
        signInButton.click();
        return new LoginPage(driver);
    }

    public HomePage crLogoClick() {
        crLogo.click();
        return new HomePage(driver);
    }


}
