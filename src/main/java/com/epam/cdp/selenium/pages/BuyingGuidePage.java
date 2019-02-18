package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyingGuidePage extends BasePage {

    @FindBy(css = ".buying-hero__title")
    private WebElement labelInHeroSection;

    @FindBy(css = ".subnav-lock-icon")
    private WebElement lockNearRecommendedLink;

    @FindBy(css = ".gnav-search__button")
    private WebElement searchButton;

    public BuyingGuidePage(WebDriver driver) {
        super(driver);
    }

    public String getLabelInHeroSectionText() {
        waitForElementVisible(labelInHeroSection);
        return labelInHeroSection.getText();
    }

    public boolean isLockNearRecommendedLinkDisplayed() {
        waitForElementVisible(searchButton);
        searchButton.click();
        searchButton.click();
        return lockNearRecommendedLink.isDisplayed();
    }
}
