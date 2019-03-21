package com.epam.cdp.selenium.services;

import com.epam.cdp.reporting.CrLogger;
import com.epam.cdp.selenium.endtoend.BasePage;

public class SearchServices {

    /**
     * Allows to search for query with Search input in global header
     *
     * @param searchQuery search query that is placed into Search input
     */
    public void doSearch(String searchQuery){
        CrLogger.info("Search for " + searchQuery);
        BasePage page = new BasePage();
        if(!page.isSearchInputVisible()){
            page.clickSearchIcon();
        }
        page.enterValueInSearchInput(searchQuery, "value");
        page.clickSearchButton();
    }
}
