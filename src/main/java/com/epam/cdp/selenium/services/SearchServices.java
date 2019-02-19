package com.epam.cdp.selenium.services;

import com.epam.cdp.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class SearchServices {

    /**
     * Allows to search for query with Search input in global header
     * @param driver WebDriver
     * @param searchQuery 'Miele Dynamic U1 Cat & Dog' brand model name
     */
    public void doSearch(WebDriver driver, String searchQuery){

        BasePage page = new BasePage(driver);
        if(!page.isSearchInputVisible()){
            page.clickSearchIcon();
        }
        page.enterValueInSearchInput(searchQuery, "value");
        page.clickSearchButton();
    }
}
