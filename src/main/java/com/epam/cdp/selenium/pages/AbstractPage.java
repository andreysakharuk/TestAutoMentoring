package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.Browser;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.epam.cdp.selenium.wait.Waiter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Waiter waiter;
    protected Browser browser;

    protected AbstractPage() {
        this.driver = WebDriverProviderSingleton.getInstance();
        this.waiter = new Waiter();
        this.browser = new Browser();
        PageFactory.initElements(this.driver, this);
    }

    public <T extends AbstractPage> T generatePage(Class<T> pageClass) {
        try {
            return pageClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
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
}
