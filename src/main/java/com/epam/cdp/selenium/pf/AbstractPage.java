package com.epam.cdp.selenium.pf;

import com.epam.cdp.selenium.utilities.ConfigProvider;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractPage {

    protected WebDriver driver;
    private ConfigProvider configProvider;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.configProvider = new ConfigProvider();
    }

    public <T extends AbstractPage> T generatePage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create page!");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, configProvider.getTimeout())
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementAttributeValue(WebElement element, String attributeName, String attributeValue) {
        new WebDriverWait(driver, configProvider.getTimeout())
                .until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }

    public void waitForTextInElementToAppear(WebElement element, String text) {
        new WebDriverWait(driver, configProvider.getTimeout())
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, configProvider.getTimeout()).until(ExpectedConditions.elementToBeClickable(element));
    }

}
