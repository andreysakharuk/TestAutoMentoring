package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButton;

    @FindBy(css = ".footer-logo")
    private WebElement crLogo;

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchInput;

    @FindBy(css = ".gnav-typeahead__button")
    private WebElement searchButton;

    @FindBy(css = "a.gnav-search__button")
    private WebElement searchIcon;

    public BasePage() {
        super();
    }

    public LoginPage clickSignInButton() {
        waiter.waitForElementVisible(signInButton);
        signInButton.click();
        return new LoginPage();
    }

    public HomePage crLogoClick() {
        crLogo.click();
        return new HomePage();
    }

    public void enterValueInSearchInput(String attributeValue, String attributeName) {
        searchInput.sendKeys(attributeValue);
        waiter.waitForElementAttributeValue(searchInput, attributeName, attributeValue);
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage();
    }

    public void clickSearchIcon(){
        searchIcon.click();
    }

    public boolean isSearchInputVisible(){
        return searchInput.isDisplayed();
    }


}
