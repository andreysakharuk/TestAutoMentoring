package com.epam.cdp.selenium;

import com.epam.cdp.reporting.CrLogger;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.google.common.collect.Iterables;
import org.openqa.selenium.*;

public class Browser {

    private WebDriver driver;

    public Browser() {
        this.driver = WebDriverProviderSingleton.getInstance();
    }

    public void navigateBack() {
        CrLogger.info("Navigating to the previous page");
        driver.navigate().back();
    }

    public void highlightElement(WebElement element) {
        CrLogger.info("Highlighting the element");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='10px solid red'", element);
    }

    public void scrollToBottomOfPage() {
        CrLogger.info("Scrolling to the bottom of the page");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void switchTab(){
        CrLogger.info("Switching to the new tab");
        String lastWindow = Iterables.getLast(driver.getWindowHandles());
        WebDriverProviderSingleton.getInstance().switchTo().window(lastWindow);
    }


}
