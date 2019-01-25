package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    protected LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy (name = "userName")
    private WebElement usernameInput;

    @FindBy (name = "password")
    private WebElement passwordInput;

    @FindBy (css = "div.gnav-sign-in__form__submit input")
    private WebElement signInButtonInLoginForm;


    public LoginPage enterUsername(String query){
        usernameInput.sendKeys(query);
        return this;
    }

    public LoginPage enterPassword(String query){
        passwordInput.sendKeys(query);
        return this;
    }

    public RatingsFullPage clickSignInButtonInLoginForm(){
        signInButtonInLoginForm.click();
        return new RatingsFullPage(driver);
    }

    public boolean isSignInButtonDisplayed(){
        waitForElementVisible(signInButtonInLoginForm);
        return isElementDisplayed(signInButtonInLoginForm);
    }

    public BuyingGuidePage clickSignInButtonInLoginFormBuyingGuide( ){
        signInButtonInLoginForm.click();
        return new BuyingGuidePage(driver);
    }

}
