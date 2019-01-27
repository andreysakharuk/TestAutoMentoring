package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(css = ".description")
    private WebElement mainArticlesSection;

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButtonInGlobalNav;

    @FindBy(css = ".account-info")
    private WebElement accountInfoSection;

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchField;

    @FindBy(css = ".gnav-typeahead__button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainArticlesSectionDisplayed() {
        return isElementDisplayed(mainArticlesSection);
    }

    public HomePage open() {
        driver.get("https://www.consumerreports.org/cro/index.htm");
        return new HomePage(driver);
    }

    public LoginPage clickOnSignInButtonInGlobalNav() {
        signInButtonInGlobalNav.click();
        return new LoginPage(driver);
    }

    public String getAccountInfoSection() {
        waitForElementVisible(accountInfoSection);
        return accountInfoSection.getText();
    }

    public HomePage enterValueInSearchField(String query) {
        searchField.sendKeys(query);
        return this;
    }

    public SearchResultPage clickOnSearchButon() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(searchField, "value", "Miele Dynamic U1 Cat & Dog"));
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
