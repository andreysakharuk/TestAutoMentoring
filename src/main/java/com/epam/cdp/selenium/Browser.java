package com.epam.cdp.selenium;

import com.google.common.collect.Iterables;
import org.openqa.selenium.*;

public class Browser {

    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='10px solid red'", element);
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void switchTab(){
        String lastWindow = Iterables.getLast(driver.getWindowHandles());
        driver.switchTo().window(lastWindow);
    }


}
