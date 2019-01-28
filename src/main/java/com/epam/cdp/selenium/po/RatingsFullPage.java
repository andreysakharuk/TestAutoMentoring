package com.epam.cdp.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class RatingsFullPage extends AbstractPage {


    private final By ctaButtonLocator = By.className("cta-top-content__header");
    private final By signInButtonGlobalNavLocator = By.className("gnav-sign-in");
    private final By recommendedToggleLocator = By.className("recommended-switcher__value");
    private final By labelsListLocator = By.xpath("//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']//*[@class='recommendation-label']");
    private final By clearAllLinkLocator = By.className("ratings-spa-filters__clear-filters");
    private final By resultCountLocator = By.cssSelector(".spa-page-counter__values >span:nth-child(2)");
    private final By priceFilterButtonLocator = By.xpath("//*[@data-id='price']");
    private final By priceLabelsListLocator = By.cssSelector(".price-filter-popover .crux-label-style");
    private final By viewButtonInPriceFilterLocator = By.cssSelector(".price-filter-popover .crux-btn.crux-btn-primary");
    private final By inputInPriceFilterLocator = By.cssSelector(".price-filter-popover .crux-input");
    private final By pricesListLocator = By.cssSelector(".classic-view__price .crux-green");
    private final By ratedBestFilterLocator = By.xpath("//*[@data-id='rated']//button");
    private final By labelInRatedBestFilterLocator = By.xpath("//*[@data-id='rated']//p");
    private final By viewButtonInRatedBestFilterLocator = By.cssSelector(".rated-filter-popover .crux-btn.crux-btn-primary");
    private final By firstCheckBoxInRatedBestFilterLocator = By.cssSelector(".shared-crux-checkbox.crux-checkbox label");
    private final By eurekaBrandCheckboxInMoreFilterLocator = By.xpath("//*[@name='Eureka-checkbox']/parent::label");
    private final By moreFilterButtonLocator = By.xpath("//*[@data-id='more-filters']");
    private final By viewButtonInMoreFilterLocator = By.cssSelector(".more-filters-popover .crux-btn.crux-btn-primary");
    private final By brandsAndModelsListLocator = By.xpath("//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']");


    public RatingsFullPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerRatingsFullPage() {
        return driver.findElement(ctaButtonLocator).getText();
    }

    public RatingsFullPage open() {
        driver.get("https://www.consumerreports.org/products/vacuum-cleaners/handheld-vacuum/view1/");
        return new RatingsFullPage(driver);
    }

    public LoginPage clickOnSignInButtonInGlobalNav() {
        driver.findElement(signInButtonGlobalNavLocator).click();
        return new LoginPage(driver);
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaButtonLocator);
    }

    public RatingsFullPage clickOnRecommendedToggle() {
        driver.findElement(recommendedToggleLocator).click();
        return this;
    }

    public ArrayList<String> getListOfLabelsFromRatingsChart() {
        ArrayList<String> listOfLabels = new ArrayList<>();
        for (WebElement label : driver.findElements(labelsListLocator)) {
            listOfLabels.add(label.getText());
        }
        return listOfLabels;
    }

    public RatingsFullPage clickOnClearAllLink() {
        driver.findElement(clearAllLinkLocator).click();
        return this;
    }

    public String getResultCount() {
        return driver.findElement(resultCountLocator).getText();
    }

    public RatingsFullPage clickOnPriceFilter() {
        driver.findElement(priceFilterButtonLocator).click();
        return this;
    }

    public String getCancelButtonInPriceFilter() {
        return driver.findElements(priceLabelsListLocator).get(2).getText();
    }

    public RatingsFullPage enterValueInPriceFilter(String a) {
        driver.findElement(inputInPriceFilterLocator).clear();
        driver.findElement(inputInPriceFilterLocator).sendKeys(a);
        return this;
    }

    public RatingsFullPage clickOnViewButtonInPriceFilter() {
        driver.findElement(viewButtonInPriceFilterLocator).click();
        return this;
    }

    public ArrayList<Integer> getListOfPricesFromRatingsChart() {
        ArrayList<Integer> listOfPrices = new ArrayList<>();
        for (WebElement price :  driver.findElements(pricesListLocator)) {
            String formattedPrice = price.getText().replace("$", "");
            listOfPrices.add(Integer.parseInt(formattedPrice));
        }
        return listOfPrices;
    }

    public RatingsFullPage clickOnRatedBestFilter() {
        driver.findElement(ratedBestFilterLocator).click();
        return this;
    }

    public String getLabelFromRatedBestFilter() {
        return  driver.findElement(labelInRatedBestFilterLocator).getText();
    }

    public RatingsFullPage selectCheckboxInRatedBestFilter() {
        driver.findElements(firstCheckBoxInRatedBestFilterLocator).get(0).click();
        return this;
    }

    public RatingsFullPage clickOnViewButtonInRatedBestFilter() {
        driver.findElement(viewButtonInRatedBestFilterLocator).click();
        return this;
    }

    public String getColorOfRatedBestFilter() {
        return  driver.findElement(ratedBestFilterLocator).getCssValue("background-color");
    }

    public RatingsFullPage clickOnMoreFilter() {
        driver.findElement(moreFilterButtonLocator).click();
        return this;
    }

    public RatingsFullPage selectEurekaBrandCheckboxInMoreFilter() {
        driver.findElement(eurekaBrandCheckboxInMoreFilterLocator).click();
        return this;
    }

    public RatingsFullPage clickOnViewButtonInMoreFilter() {
        driver.findElement(viewButtonInMoreFilterLocator).click();
        return this;
    }

    public ArrayList<String> getListOfBrandsAndModelsFromRatingsChart() {
        ArrayList<String> listOfBrandsAndModels = new ArrayList<>();
        for (WebElement brandModel : driver.findElements(brandsAndModelsListLocator)) {
            listOfBrandsAndModels.add(brandModel.getText());
        }
        return listOfBrandsAndModels;
    }
}