package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.Browser;
import org.openqa.selenium.WebDriver;
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

    public ModelPage(WebDriver driver) {
        super(driver);
    }

    public ModelPage open() {
        driver.get(MODEL_PAGE_URL);
        return new ModelPage(driver);
    }

    public boolean isPriceAndShopTitleDisplayed() {
        waitForElementVisible(priceAndShopTitle);
        return priceAndShopTitle.isDisplayed();
    }

    public AmazonPage clickAmazonButton() {
        new Actions(driver).moveToElement(amazonButton).build().perform();
        waitForElementClickable(amazonButton);
        amazonButton.click();
        new Browser(driver).switchTab();
        return new AmazonPage(driver);
    }

    public OverviewPage clickUprightVacuumsLinkInBreadcrumbs() {
        breadcrumbsList.get(2).click();
        return new OverviewPage(driver);
    }

    public String getTitle() {
        waitForElementVisible(title);
        return title.getText();
    }
}
