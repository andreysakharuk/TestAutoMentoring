package com.epam.cdp.selenium.pf;

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

    @FindBy(css = ".gnav-search__button")
    private WebElement searchButton;

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

    public boolean isLockNearRecommendedLinkDisplayed(){
        waitForElementVisible(searchButton);
        searchButton.click();
        searchButton.click();
        return lockNearRecommendedLink.isDisplayed();
    }
}
