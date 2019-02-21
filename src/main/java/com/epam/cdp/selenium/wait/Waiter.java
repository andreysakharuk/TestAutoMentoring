package com.epam.cdp.selenium.wait;

import com.epam.cdp.base.ConfigProvider;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private ConfigProvider configProvider;

    public Waiter() {
        this.configProvider = new ConfigProvider();
    }

    public void waitForElementVisible(WebElement element) {
        new WebDriverWait(WebDriverProviderSingleton.getInstance(), configProvider.getTimeout())
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementAttributeValue(WebElement element, String attributeName, String attributeValue) {
        new WebDriverWait(WebDriverProviderSingleton.getInstance(), configProvider.getTimeout())
                .until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }

    public void waitForTextInElementToAppear(WebElement element, String text) {
        new WebDriverWait(WebDriverProviderSingleton.getInstance(), configProvider.getTimeout())
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(WebDriverProviderSingleton.getInstance(), configProvider.getTimeout()).until(ExpectedConditions.elementToBeClickable(element));
    }


}
