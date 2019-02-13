package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.pf.BasePage;
import com.epam.cdp.selenium.pf.HomePage;
import org.openqa.selenium.WebDriver;

public class SearchServices {

    public void doSearch(BasePage page, WebDriver driver, String attributeName, String attributeValue){
        if (page instanceof HomePage){
            page.enterValueInSearchInput(attributeValue, attributeName);
            page.clickSearchButton();
        } else {
            page.clickSearchIcon();
            page.enterValueInSearchInput(attributeValue, attributeName);
            page.clickSearchButton();
            driver.quit();
        }
    }
}
