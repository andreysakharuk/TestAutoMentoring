package com.epam.cdp.selenium.pages;

import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = WebDriverProviderSingleton.getInstance();
    }

    public <T extends AbstractPage> T generatePage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(WebDriverProviderSingleton.getInstance());
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

}
