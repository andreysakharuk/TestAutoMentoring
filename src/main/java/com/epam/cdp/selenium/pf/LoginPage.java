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
    private WebElement signInButtonInLoginForm;

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

    public RatingsFullPage clickSignInButtonInLoginFormRatingsFullPage() {
        signInButtonInLoginForm.click();
        return new RatingsFullPage(driver);
    }

    public boolean isSignInButtonDisplayed() {
        waitForElementVisible(signInButtonInLoginForm);
        return isElementDisplayed(signInButtonInLoginForm);
    }

    public BuyingGuidePage clickSignInButtonInLoginFormBuyingGuide() {
        signInButtonInLoginForm.click();
        return new BuyingGuidePage(driver);
    }

    public HomePage clickSignInButtonInLoginFormHomePage() {
        signInButtonInLoginForm.click();
        return new HomePage(driver);
    }
}
