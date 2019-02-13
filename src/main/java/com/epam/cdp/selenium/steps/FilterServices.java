package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.pf.RatingsPage;

public class FilterServices{

    public void doPriceFiltering(RatingsPage page, String price) {
        page.clickPriceFilterButton().enterValueInPriceFilterPopup(price).clickViewButtonInPriceFilterPopup();
    }

    public void doRatedBestFiltering(RatingsPage page, int checkbox){
        page.clickRatedBestFilterButton().selectCheckboxInRatedBestFilterPopup(checkbox).clickViewButtonInRatedBestFilterPopup();
    }

    public void doMoreFiltering(RatingsPage page, String brandCheckbox){
        page.clickMoreFilterButton().selectBrandCheckboxInMoreFilterPopup(brandCheckbox).clickViewButtonInMoreFilterPopup();
    }
}
