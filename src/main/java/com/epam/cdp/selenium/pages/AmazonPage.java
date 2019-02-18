package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPage extends AbstractPage {

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        waitForElementVisible(productTitle);
        return driver.getCurrentUrl();
    }
}
