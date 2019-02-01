package com.epam.cdp.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RatingsFullPage extends AbstractPage {

    private static final String RATINGS_FULL_PAGE_URL = "https://www.consumerreports.org/products/vacuum-cleaners/handheld-vacuum/view1/";

    private final By ctaButtonLocator = By.className("cta-top-content__header");
    private final By recommendedToggleLocator = By.className("recommended-switcher__value");
    private final By labelsListLocator = By.xpath("//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']//*[@class='recommendation-label']");
    private final By clearAllLinkLocator = By.className("ratings-spa-filters__clear-filters");
    private final By resultCountLocator = By.cssSelector(".spa-page-counter__values >span:nth-child(2)");
    private final By priceFilterButtonLocator = By.xpath("//*[@data-id='price']");
    private final By priceLabelsListLocator = By.cssSelector(".price-filter-popover .crux-label-style");
    private final By viewButtonInPriceFilterPopupLocator = By.cssSelector(".price-filter-popover .crux-btn.crux-btn-primary");
    private final By inputInPriceFilterPopupLocator = By.cssSelector(".price-filter-popover .crux-input");
    private final By pricesListLocator = By.cssSelector(".classic-view__price .crux-green");
    private final By ratedBestFilterButtonLocator = By.xpath("//*[@data-id='rated']//button");
    private final By labelInRatedBestFilterPopupLocator = By.xpath("//*[@data-id='rated']//p");
    private final By viewButtonInRatedBestFilterPopupLocator = By.cssSelector(".rated-filter-popover .crux-btn.crux-btn-primary");
    private final By checkBoxInRatedBestFilterPopupLocator = By.cssSelector(".shared-crux-checkbox.crux-checkbox label");
    private final By eurekaBrandCheckboxInMoreFilterPopupLocator = By.xpath("//*[@name='Eureka-checkbox']/parent::label");
    private final By moreFilterButtonLocator = By.xpath("//*[@data-id='more-filters']");
    private final By viewButtonInMoreFilterPopupLocator = By.cssSelector(".more-filters-popover .crux-btn.crux-btn-primary");
    private final By brandsAndModelsListLocator = By.xpath("//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']");


    public RatingsFullPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerText() {
        return driver.findElement(ctaButtonLocator).getText();
    }

    public RatingsFullPage open() {
        driver.get(RATINGS_FULL_PAGE_URL);
        return new RatingsFullPage(driver);
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaButtonLocator);
    }

    public RatingsFullPage clickRecommendedToggle() {
        driver.findElement(recommendedToggleLocator).click();
        return this;
    }

    public List<String> getLabelsListInRatingsChart() {
        List<String> labelsListFull = driver.findElements(labelsListLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return labelsListFull;
    }

    public RatingsFullPage clickClearAllLink() {
        driver.findElement(clearAllLinkLocator).click();
        return this;
    }

    public String getResultCount() {
        return driver.findElement(resultCountLocator).getText();
    }

    public RatingsFullPage clickPriceFilterButton() {
        driver.findElement(priceFilterButtonLocator).click();
        return this;
    }

    public String getCancelButtonTextInPriceFilterPopup() {
        return driver.findElements(priceLabelsListLocator).get(2).getText();
    }

    public RatingsFullPage enterValueInPriceFilterPopup(String a) {
        driver.findElement(inputInPriceFilterPopupLocator).clear();
        driver.findElement(inputInPriceFilterPopupLocator).sendKeys(a);
        return this;
    }

    public RatingsFullPage clickViewButtonInPriceFilterPopup() {
        driver.findElement(viewButtonInPriceFilterPopupLocator).click();
        return this;
    }

    public List<Integer> getPricesListInRatingsChart() {
        List<Integer> pricesListFull = new ArrayList<>();
        for (WebElement price : driver.findElements(pricesListLocator)) {
            String formattedPrice = price.getText().replace("$", "");
            pricesListFull.add(Integer.parseInt(formattedPrice));
        }
        return pricesListFull;
    }

    public RatingsFullPage clickRatedBestFilterButton() {
        driver.findElement(ratedBestFilterButtonLocator).click();
        return this;
    }

    public String getLabelFromRatedBestFilterPopup() {
        return driver.findElement(labelInRatedBestFilterPopupLocator).getText();
    }

    public RatingsFullPage selectCheckboxInRatedBestFilterPopup() {
        driver.findElements(checkBoxInRatedBestFilterPopupLocator).get(0).click();
        return this;
    }

    public RatingsFullPage clickViewButtonInRatedBestFilterPopup() {
        driver.findElement(viewButtonInRatedBestFilterPopupLocator).click();
        return this;
    }

    public String getColorOfRatedBestFilterButton() {
        return driver.findElement(ratedBestFilterButtonLocator).getCssValue("background-color");
    }

    public RatingsFullPage clickMoreFilterButton() {
        driver.findElement(moreFilterButtonLocator).click();
        return this;
    }

    public RatingsFullPage selectEurekaBrandCheckboxInMoreFilterPopup() {
        driver.findElement(eurekaBrandCheckboxInMoreFilterPopupLocator).click();
        return this;
    }

    public RatingsFullPage clickViewButtonInMoreFilterPopup() {
        driver.findElement(viewButtonInMoreFilterPopupLocator).click();
        return this;
    }

    public List<String> getBrandsAndModelsListFromRatingsChart() {
        List<String> brandsAndModelsListFull = driver.findElements(brandsAndModelsListLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return brandsAndModelsListFull;
    }
}