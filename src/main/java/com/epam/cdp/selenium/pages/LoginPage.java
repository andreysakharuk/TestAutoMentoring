package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(name = "userName")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "div.gnav-sign-in__form__submit input")
    private WebElement signInButton;

    public LoginPage() {
        super();
    }

    public LoginPage enterUsername(String query) {
        usernameInput.sendKeys(query);
        return this;
    }

    public LoginPage enterPassword(String query) {
        passwordInput.sendKeys(query);
        return this;
    }

    public <T extends BasePage> T clickSignInButton(Class<T> pageClass) {
        signInButton.click();
        return generatePage(pageClass);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
