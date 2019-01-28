package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {

    @FindBy(css = ".text.mobile-text.crux-component-title p")
    private WebElement heroSection;

    @FindBy(css = ".crux-product-title a")
    private WebElement linkInTypeSection;

    @FindBy(css = ".buying-guide a")
    private WebElement buyingGuideLink;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage open() {
        driver.get("https://www.consumerreports.org/cro/vacuum-cleaners.htm");
        return new OverviewPage(driver);
    }

    public String getHeroSectionText() {
        waitForElementVisible(heroSection);
        return heroSection.getText();
    }

    public RatingsCompactPage clickOnUprightLinkInTypeSection() {
        linkInTypeSection.click();
        return new RatingsCompactPage(driver);
    }

    public BuyingGuidePage clickOnBuyingGuideLink() {
        waitForElementVisible(buyingGuideLink);
        buyingGuideLink.click();
        return new BuyingGuidePage(driver);
    }
}
