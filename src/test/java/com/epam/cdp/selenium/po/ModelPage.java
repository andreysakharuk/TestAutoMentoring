package com.epam.cdp.selenium.po;

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

    @FindBy(xpath = "//button[@class='crux-btn crux-btn crux-btn-special--sm']")
    private WebElement amazonButton;

    @FindBy(css =".gnav-breadcrumbs li")
    private List<WebElement> breadcrumbsList;

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

    public String clickOnAmazonButtonAndGetUrl() {
        waitForElementVisible(amazonButton);
        new Actions(driver).moveToElement(amazonButton).perform();
        amazonButton.click();
        Set<String> handles =  driver.getWindowHandles();
        Iterator<String> handleIt = handles.iterator();
        while(handleIt.hasNext()) {
            String handle = handleIt.next();
            driver.switchTo().window(handle);
        }
        return driver.getCurrentUrl();
    }

    public OverviewPage clickOnUprightVacuumsLinkInBreadcrumbs() {
        breadcrumbsList.get(2).click();
        return new OverviewPage(driver);
    }
}
