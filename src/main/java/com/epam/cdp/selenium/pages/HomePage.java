package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.wait.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.consumerreports.org/cro/index.htm";

    @FindBy(css = ".description")
    private WebElement mainArticlesSection;

    @FindBy(css = ".account-info")
    private WebElement accountInfoSection;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainArticlesSectionDisplayed() {
        return isElementDisplayed(mainArticlesSection);
    }

    public HomePage open() {
        driver.get(HOME_PAGE_URL);
        return new HomePage(driver);
    }

    public String getAccountInfoSectionText() {
        new Waiter().waitForElementVisible(accountInfoSection);
        return accountInfoSection.getText();
    }

}
