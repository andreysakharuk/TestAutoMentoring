package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class RatingsPage extends AbstractPage {

    @FindBy(xpath = "//*[@alt='view']")
    private List<WebElement> switcherIcons;

    @FindBy(className = "cta-top-content__header")
    private WebElement ctaBanner;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareCircleNumber;

    public RatingsPage(WebDriver driver) {
        super(driver);
    }

    public <T extends RatingsPage> T clickIconInSwitcher(Class<T> pageClass, int icon) {
        switcherIcons.get(icon).click();
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Unable to create page!");
        }
    }

    public String getCtaBannerText() {
        return ctaBanner.getText();
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaBanner);
    }

    public String getCompareCircleNumber() {
        waitForElementVisible(compareCircleNumber);
        return compareCircleNumber.getText();
    }

}