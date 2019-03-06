package com.epam.cdp.selenium.endtoend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyingGuidePage extends BasePage {

    @FindBy(css = ".buying-hero__title")
    private WebElement labelInHeroSection;

    @FindBy(css = ".subnav-lock-icon")
    private WebElement lockNearRecommendedLink;

    @FindBy(css = ".gnav-search__button")
    private WebElement searchButton;

    public BuyingGuidePage() {
        super();
    }

    public String getLabelInHeroSectionText() {
        waiter.waitForElementVisible(labelInHeroSection);
        return labelInHeroSection.getText();
    }

    public boolean isLockNearRecommendedLinkDisplayed() {
        clickSearchIcon();
        return lockNearRecommendedLink.isDisplayed();
    }
}
