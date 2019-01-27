package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RatingsFullPage extends AbstractPage {

    @FindBy(className = "cta-top-content__header")
    private WebElement ctaButton;

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButtonGlobalNav;

    @FindBy(className = "recommended-switcher__value")
    private WebElement recommendedToggle;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']//*[@class='recommendation-label']")
    private List<WebElement> lablesList;

    @FindBy(className = "ratings-spa-filters__clear-filters")
    private WebElement clearAllLink;

    @FindBy(css = ".spa-page-counter__values >span:nth-child(2)")
    private WebElement resultCount;

    @FindBy(xpath = "//*[@data-id='price']")
    private WebElement priceFilterButton;

    @FindBy(css = ".price-filter-popover .crux-label-style")
    private List<WebElement> priceLabelsList;

    @FindBy(css = ".price-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInPriceFilter;

    @FindBy(css = ".price-filter-popover .crux-input")
    private WebElement inputInPriceFilter;

    @FindBy(css = ".classic-view__price .crux-green")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//*[@data-id='rated']//button")
    private WebElement ratedBestFilter;

    @FindBy(xpath = "//*[@data-id='rated']//p")
    private WebElement labelInRatedBestFilter;

    @FindBy(css = ".rated-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInRatedBestFilter;

    @FindBy(css = ".shared-crux-checkbox.crux-checkbox label")
    private List<WebElement> firstCheckBoxInRatedBestFilter;

    @FindBy(xpath = "//*[@name='Eureka-checkbox']/parent::label")
    private WebElement eurekaBrandCheckboxInMoreFilter;

    @FindBy(xpath = "//*[@data-id='more-filters']")
    private WebElement moreFilterButton;

    @FindBy(css = ".more-filters-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInMoreFilter;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']")
    private List<WebElement> brandsAndModelsList;

    @FindBy(css = "div.classic-view")
    private WebElement ratingsFullView;

    @FindBy(css = ".shared-crux-tooltip .compare-icon")
    private List<WebElement> compareButtons;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareCircleNumber;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareBucket;

    @FindBy(xpath = "//*[@data-display='true']//button[@class='crux-btn crux-btn-special--lg']")
    private WebElement viewCompareButton;

    public RatingsFullPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerRatingsFullPage() {
        return ctaButton.getText();
    }

    public RatingsFullPage open() {
        driver.get("https://www.consumerreports.org/products/vacuum-cleaners/handheld-vacuum/view1/");
        return new RatingsFullPage(driver);
    }

    public LoginPage clickOnSignInButtonInGlobalNav() {
        signInButtonGlobalNav.click();
        return new LoginPage(driver);
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaButton);
    }

    public RatingsFullPage clickOnRecommendedToggle() {
        recommendedToggle.click();
        return this;
    }

    public ArrayList<String> getListOfLabelsFromRatingsChart() {
        ArrayList<String> listOfLabels = new ArrayList<>();
        for (WebElement label : lablesList) {
            listOfLabels.add(label.getText());
        }
        return listOfLabels;
    }

    public RatingsFullPage clickOnClearAllLink() {
        clearAllLink.click();
        return this;
    }

    public String getResultCount() {
        return resultCount.getText();
    }

    public RatingsFullPage clickOnPriceFilter() {
        priceFilterButton.click();
        return this;
    }

    public String getCancelButtonInPriceFilter() {
        return priceLabelsList.get(2).getText();
    }

    public RatingsFullPage enterValueInPriceFilter(String a) {
        inputInPriceFilter.clear();
        inputInPriceFilter.sendKeys(a);
        return this;
    }

    public RatingsFullPage clickOnViewButtonInPriceFilter() {
        viewButtonInPriceFilter.click();
        return this;
    }

    public ArrayList<Integer> getListOfPricesFromRatingsChart() {
        ArrayList<Integer> listOfPrices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String formattedPrice = price.getText().replace("$", "");
            listOfPrices.add(Integer.parseInt(formattedPrice));
        }
        return listOfPrices;
    }

    public RatingsFullPage clickOnRatedBestFilter() {
        ratedBestFilter.click();
        return this;
    }

    public String getLabelFromRatedBestFilter() {
        return labelInRatedBestFilter.getText();
    }

    public RatingsFullPage selectCheckboxInRatedBestFilter() {
        firstCheckBoxInRatedBestFilter.get(0).click();
        return this;
    }

    public RatingsFullPage clickOnViewButtonInRatedBestFilter() {
        viewButtonInRatedBestFilter.click();
        return this;
    }

    public String getColorOfRatedBestFilter() {
        return ratedBestFilter.getCssValue("background-color");
    }

    public RatingsFullPage clickOnMoreFilter() {
        moreFilterButton.click();
        return this;
    }

    public RatingsFullPage selectEurekaBrandCheckboxInMoreFilter() {
        eurekaBrandCheckboxInMoreFilter.click();
        return this;
    }

    public RatingsFullPage clickOnViewButtonInMoreFilter() {
        viewButtonInMoreFilter.click();
        return this;
    }

    public ArrayList<String> getListOfBrandsAndModelsFromRatingsChart() {
        ArrayList<String> listOfBrandsAndModels = new ArrayList<>();
        for (WebElement brandModel : brandsAndModelsList) {
            listOfBrandsAndModels.add(brandModel.getText());
        }
        return listOfBrandsAndModels;
    }

    public boolean isRatingsFullViewDisplayed() {
        return ratingsFullView.isDisplayed();
    }

    public RatingsFullPage clickOnAddToCompareButton() {
        compareButtons.get(0).click();
        return this;
    }

    public String getCompareCircleNumber() {
        waitForElementVisible(compareCircleNumber);
        return compareCircleNumber.getText();
    }

    public RatingsFullPage clickOnCompareBucket() {
        compareBucket.click();
        return new RatingsFullPage(driver);
    }

    public ComparePage clickOnViewCompare() {
        viewCompareButton.click();
        return new ComparePage(driver);
    }
}
