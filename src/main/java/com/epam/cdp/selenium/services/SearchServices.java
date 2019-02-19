package com.epam.cdp.selenium.services;

import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.epam.cdp.selenium.pages.BasePage;

public class SearchServices {

    /**
     * Allows to search for query with Search input in global header
     *
     * @param searchQuery search query that is placed into Search input
     */
    public void doSearch(String searchQuery){

        BasePage page = new BasePage(WebDriverProviderSingleton.getInstance());
        if(!page.isSearchInputVisible()){
            page.clickSearchIcon();
        }
        page.enterValueInSearchInput(searchQuery, "value");
        page.clickSearchButton();
    }
}
