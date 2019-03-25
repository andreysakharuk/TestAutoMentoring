package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.logging.CrLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ModelPage extends RatingsPage {

    private static final String MODEL_PAGE_URL =
            "https://www.consumerreports.org/products/vacuum-cleaners/upright-vacuum/bissell-cleanview-plus-rewind-1332-387595/";

    @FindBy(css = ".price-and-shop__title.crux-call-to-action")
    private WebElement priceAndShopTitle;

    @FindBy(css = "a.price-and-shop__button")
    private WebElement amazonButton;

    @FindBy(css = ".gnav-breadcrumbs li")
    private List<WebElement> breadcrumbsList;

    @FindBy(css = "span.crux-page-title")
    private WebElement title;

    @FindBy(css = ".related-articles__news-header")
    private WebElement relatedArticlesSection;

    @FindBy(css = ".price-and-shop__title")
    private WebElement priceAndShopHeader;

    public ModelPage() {
        super();
    }

    public ModelPage open() {
        CrLogger.info("Going to Model page:" + MODEL_PAGE_URL);
        driver.get(MODEL_PAGE_URL);
        return new ModelPage();
    }

    public boolean isPriceAndShopTitleDisplayed() {
        waiter.waitForElementVisible(priceAndShopTitle);
        return priceAndShopTitle.isDisplayed();
    }

    public AmazonPage clickAmazonButton() {
        CrLogger.info("Clicking Amazon Shop button");
        new Actions(driver).moveToElement(priceAndShopHeader).build().perform();
        new Actions(driver).moveToElement(amazonButton).build().perform();
        waiter.waitForElementClickable(amazonButton);
        amazonButton.click();
        browser.switchTab();
        return new AmazonPage();
    }

    public OverviewPage clickUprightVacuumsLinkInBreadcrumbs() {
        CrLogger.info("Clicking link in Breadcrumbs");
        breadcrumbsList.get(2).click();
        return new OverviewPage();
    }

    public String getTitle() {
        waiter.waitForElementVisible(title);
        return title.getText();
    }
}
