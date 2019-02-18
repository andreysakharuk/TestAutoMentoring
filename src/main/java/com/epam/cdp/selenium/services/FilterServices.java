package com.epam.cdp.selenium.services;

import com.epam.cdp.selenium.pages.RatingsPage;
import org.openqa.selenium.WebDriver;

public class FilterServices{

    /**
     * Apply 'Price' filter with selected price value
     * @param driver WebDriver
     * @param price 100
     */
    public void doPriceFiltering(WebDriver driver, String price) {
        new RatingsPage(driver).clickPriceFilterButton().enterValueInPriceFilterPopup(price).clickViewButtonInPriceFilterPopup();
    }

    /**
     * Apply 'Rated Best For' filter with selected checkbox value
     * @param driver WebDriver
     * @param checkbox 0
     */
    public void doRatedBestFiltering(WebDriver driver, int checkbox){
        new RatingsPage(driver).clickRatedBestFilterButton().selectCheckboxInRatedBestFilterPopup(checkbox).clickViewButtonInRatedBestFilterPopup();
    }

    /**
     * Apply 'More' filter with selected brand checkbox
     * @param driver WebDriver
     * @param brandCheckbox Eureka
     */
    public void doMoreFiltering(WebDriver driver, String brandCheckbox){
        new RatingsPage(driver).clickMoreFilterButton().selectBrandCheckboxInMoreFilterPopup(brandCheckbox).clickViewButtonInMoreFilterPopup();
    }
}
