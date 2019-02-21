package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    private static final String OVERVIEW_PAGE_URL = "https://www.consumerreports.org/cro/vacuum-cleaners.htm";

    @FindBy(css = ".text.mobile-text.crux-component-title p")
    private WebElement heroSection;

    @FindBy(css = ".crux-product-title a")
    private WebElement typeSectionLink;

    @FindBy(css = ".buying-guide a")
    private WebElement buyingGuideLink;

    public OverviewPage( ) {
        super();
    }

    public OverviewPage open() {
        driver.get(OVERVIEW_PAGE_URL);
        return new OverviewPage();
    }

    public String getHeroSectionText() {
        waiter.waitForElementVisible(heroSection);
        return heroSection.getText();
    }

    public RatingsCompactPage clickUprightLinkInTypeSection() {
        typeSectionLink.click();
        return new RatingsCompactPage();
    }

    public BuyingGuidePage clickBuyingGuideLink() {
        waiter.waitForElementVisible(buyingGuideLink);
        buyingGuideLink.click();
        return new BuyingGuidePage();
    }
}
