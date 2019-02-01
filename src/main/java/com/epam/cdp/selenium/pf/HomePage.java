package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    private static final String HOME_PAGE_URL = "https://www.consumerreports.org/cro/index.htm";

    @FindBy(css = ".description")
    private WebElement mainArticlesSection;

    @FindBy(css = ".account-info")
    private WebElement accountInfoSection;

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchInput;

    @FindBy(css = ".gnav-typeahead__button")
    private WebElement searchButton;


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
        waitForElementVisible(accountInfoSection);
        return accountInfoSection.getText();
    }

    public HomePage enterValueInSearchInput(String attributeValue, String attributeName) {
        searchInput.sendKeys(attributeValue);
        waitForElementAttributeValue(searchInput, attributeName, attributeValue);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
