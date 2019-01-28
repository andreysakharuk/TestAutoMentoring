package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ModelPage extends AbstractPage {

    @FindBy(css = ".price-and-shop__title.crux-call-to-action")
    private WebElement priceAndShopTitle;

    @FindBy(css = "a.price-and-shop__button")
    private WebElement amazonButton;

    @FindBy(css = ".gnav-breadcrumbs li")
    private List<WebElement> breadcrumbsList;

    @FindBy(css = "span.crux-page-title")
    private WebElement title;

    @FindBy(xpath = "//*[@alt='view']")
    private List<WebElement> switcherIcons;

    @FindBy(css = ".related-articles__news-header")
    private WebElement relatedArticlesSection;

    public ModelPage(WebDriver driver) {
        super(driver);
    }

    public ModelPage open() {
        driver.get("https://www.consumerreports.org/products/vacuum-cleaners/upright-vacuum/bissell-cleanview-plus-rewind-1332-387595/");
        return new ModelPage(driver);
    }

    public boolean isPriceAndShopTitleDisplayed() {
        waitForElementVisible(priceAndShopTitle);
        return priceAndShopTitle.isDisplayed();
    }

    public AmazonPage clickOnAmazonButton(){
        new Actions(driver).moveToElement(amazonButton).perform();
        waitForElementVisible(amazonButton);
        amazonButton.click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> handleIt = handles.iterator();
        while (handleIt.hasNext()) {
            String handle = handleIt.next();
            driver.switchTo().window(handle);
        }
        return new AmazonPage(driver);
    }

    public OverviewPage clickOnUprightVacuumsLinkInBreadcrumbs() {
        breadcrumbsList.get(2).click();
        return new OverviewPage(driver);
    }

    public String getTitle() {
        waitForElementVisible(title);
        return title.getText();
    }

    public RatingsCompactPage clickOnRatingsCompactIcon() {
        switcherIcons.get(1).click();
        return new RatingsCompactPage(driver);
    }
}
