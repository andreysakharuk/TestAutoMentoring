package com.epam.cdp.selenium.pf;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementAttributeValue(WebElement element, String attributeName, String attributeValue) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }

    public void waitForTextInElementToAppear(WebElement element, String text) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

}
