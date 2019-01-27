package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyingGuidePage extends AbstractPage {

    @FindBy(css = ".buying-hero__title")
    private WebElement labelInHeroSection;

    @FindBy(css = ".gnav-sign-in__text")
    private WebElement signInButton;

    @FindBy(css = ".subnav-lock-icon")
    private WebElement lockNearRecommendedLink;

    public BuyingGuidePage(WebDriver driver) {
        super(driver);
    }

    public String getLabelInHeroSection() {
        waitForElementVisible(labelInHeroSection);
        return labelInHeroSection.getText();
    }

    public LoginPage clickOnSignInLink() {
        waitForElementVisible(signInButton);
        signInButton.click();
        return new LoginPage(driver);
    }

    public boolean isLockNearRecommendedLinkDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return lockNearRecommendedLink.isDisplayed();
    }
}
