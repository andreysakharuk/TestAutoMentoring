package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.wait.Waiter;
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
        new Waiter().waitForElementVisible(productTitle);
        return driver.getCurrentUrl();
    }
}
