package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

public class LoginPage extends AbstractPage {

    @FindBy(name = "userName")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "div.gnav-sign-in__form__submit input")
    private WebElement signInButton;

    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String query) {
        usernameInput.sendKeys(query);
        return this;
    }

    public LoginPage enterPassword(String query) {
        passwordInput.sendKeys(query);
        return this;
    }

    public boolean isSignInButtonDisplayed() {
        return isElementDisplayed(signInButton);
    }

    public <T extends AbstractPage> T clickSignInButton(Class<T> pageClass){
        signInButton.click();
        try{
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);

        }catch(IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e){
            throw new RuntimeException("Unable to create page!");
        }
    }
}
