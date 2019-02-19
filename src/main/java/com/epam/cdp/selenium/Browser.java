package com.epam.cdp.selenium;

import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.google.common.collect.Iterables;
import org.openqa.selenium.*;

public class Browser {

    public void navigateBack() {
        WebDriverProviderSingleton.getInstance().navigate().back();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) WebDriverProviderSingleton.getInstance());
        js.executeScript("arguments[0].style.border='10px solid red'", element);
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor js = ((JavascriptExecutor) WebDriverProviderSingleton.getInstance());
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void switchTab(){
        String lastWindow = Iterables.getLast(WebDriverProviderSingleton.getInstance().getWindowHandles());
        WebDriverProviderSingleton.getInstance().switchTo().window(lastWindow);
    }


}
