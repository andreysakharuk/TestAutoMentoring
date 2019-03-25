package com.epam.cdp.selenium.services;

import com.epam.cdp.logging.CrLogger;
import com.epam.cdp.selenium.endtoend.RatingsPage;

public class FilterServices {

    /**
     * Apply 'Price' filter with selected price value
     *
     * @param price price used for filtering
     */
    public void doPriceFiltering(String price) {
        CrLogger.info("Applying Price filtering");
        new RatingsPage()
                .clickPriceFilterButton()
                .enterValueInPriceFilterPopup(price)
                .clickViewButtonInPriceFilterPopup();
    }

    /**
     * Apply 'Rated Best For' filter with selected checkbox value
     *
     * @param checkbox position of needed to select checkbox starting with 0
     */
    public void doRatedBestFiltering(int checkbox) {
        CrLogger.info("Applying Best filtering");
        new RatingsPage()
                .clickRatedBestFilterButton()
                .selectCheckboxInRatedBestFilterPopup(checkbox)
                .clickViewButtonInRatedBestFilterPopup();
    }

    /**
     * Apply 'More' filter with selected brand checkbox
     *
     * @param brandCheckbox Name of Brand checkbox
     */
    public void doMoreFiltering(String brandCheckbox){
        CrLogger.info("Applying More filtering");
        new RatingsPage()
                .clickMoreFilterButton()
                .selectBrandCheckboxInMoreFilterPopup(brandCheckbox)
                .clickViewButtonInMoreFilterPopup();
    }
}
