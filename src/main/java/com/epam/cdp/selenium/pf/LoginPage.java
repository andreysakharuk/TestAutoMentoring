package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        waitForElementVisible(signInButton);
        return isElementDisplayed(signInButton);
    }

    public RatingsFullPage clickSignInButtonInLoginFormRatingsFullPage() {
        signInButton.click();
        return new RatingsFullPage(driver);
    }


    public BuyingGuidePage clickSignInButtonInLoginFormBuyingGuide() {
        signInButton.click();
        return new BuyingGuidePage(driver);
    }

    public HomePage clickSignInButtonInLoginFormHomePage() {
        signInButton.click();
        return new HomePage(driver);
    }
}
