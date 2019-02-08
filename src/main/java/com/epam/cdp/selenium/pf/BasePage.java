package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButton;

    @FindBy(css = ".footer-logo")
    private WebElement crLogo;

    public BasePage(WebDriver driver) {
        super(driver);
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
