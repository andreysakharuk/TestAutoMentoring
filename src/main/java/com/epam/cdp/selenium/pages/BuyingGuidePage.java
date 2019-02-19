package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.wait.Waiter;
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
        new Waiter().waitForElementVisible(labelInHeroSection);
        return labelInHeroSection.getText();
    }

    public boolean isLockNearRecommendedLinkDisplayed() {
        clickSearchIcon();
        /*
        new Waiter().waitForElementVisible(searchButton);
        searchButton.click();
        searchButton.click();
        */
        return lockNearRecommendedLink.isDisplayed();
    }
}
