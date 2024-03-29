package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.logging.CrLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.consumerreports.org/cro/index.htm";

    @FindBy(css = ".description")
    private WebElement mainArticlesSection;

    @FindBy(css = ".account-info")
    private WebElement accountInfoSection;


    public HomePage() {
        super();
    }

    public boolean isMainArticlesSectionDisplayed() {
        return isElementDisplayed(mainArticlesSection);
    }

    public HomePage open() {
        CrLogger.info("Going to Home page: " + HOME_PAGE_URL);
        driver.get(HOME_PAGE_URL);
        return new HomePage();
    }

    public String getAccountInfoSectionText() {
        waiter.waitForElementVisible(accountInfoSection);
        return accountInfoSection.getText();
    }

}
