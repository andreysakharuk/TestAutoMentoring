package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RatingsFullPage extends AbstractPage {

    private static final String RATINGS_FULL_PAGE_URL = "https://www.consumerreports.org/products/vacuum-cleaners/handheld-vacuum/view1/";

    @FindBy(className = "cta-top-content__header")
    private WebElement ctaBanner;

    @FindBy(className = "gnav-sign-in")
    private WebElement signInButton;

    @FindBy(className = "recommended-switcher__value")
    private WebElement recommendedToggle;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']//*[@class='recommendation-label']")
    private List<WebElement> labelsList;

    @FindBy(className = "ratings-spa-filters__clear-filters")
    private WebElement clearAllLink;

    @FindBy(css = ".spa-page-counter__values >span:nth-child(2)")
    private WebElement resultCount;

    @FindBy(xpath = "//*[@data-id='price']")
    private WebElement priceFilterButton;

    @FindBy(css = ".price-filter-popover .crux-label-style")
    private List<WebElement> priceLabelsList;

    @FindBy(css = ".price-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInPriceFilterPopup;

    @FindBy(css = ".price-filter-popover .crux-input")
    private WebElement inputInPriceFilterPopup;

    @FindBy(css = ".classic-view__price .crux-green")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//*[@data-id='rated']//button")
    private WebElement ratedBestFilterButton;

    @FindBy(xpath = "//*[@data-id='rated']//p")
    private WebElement labelInRatedBestFilterPopup;

    @FindBy(css = ".rated-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInRatedBestFilterPopup;

    @FindBy(css = ".shared-crux-checkbox.crux-checkbox label")
    private List<WebElement> checkBoxInRatedBestFilterPopup;

    @FindBy(xpath = "//*[@name='Eureka-checkbox']/parent::label")
    private WebElement eurekaBrandCheckboxInMoreFilterPopup;

    @FindBy(xpath = "//*[@data-id='more-filters']")
    private WebElement moreFilterButton;

    @FindBy(css = ".more-filters-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInMoreFilterPopup;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']")
    private List<WebElement> brandsAndModelsList;

    @FindBy(css = "div.classic-view")
    private WebElement ratingsFullView;

    @FindBy(css = ".shared-crux-tooltip .compare-icon")
    private List<WebElement> compareButtons;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareCircleNumber;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareBucketButton;

    @FindBy(xpath = "//*[@data-display='true']//button[@class='crux-btn crux-btn-special--lg']")
    private WebElement viewCompareButton;

    public RatingsFullPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerText() {
        return ctaBanner.getText();
    }

    public RatingsFullPage open() {
        driver.get(RATINGS_FULL_PAGE_URL);
        return new RatingsFullPage(driver);
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaBanner);
    }

    public RatingsFullPage clickRecommendedToggle() {
        recommendedToggle.click();
        return this;
    }

    public List<String> getListOfLabelsFromRatingsChart() {
        List<String> labelsListFull = labelsList.stream().map(WebElement::getText).collect(Collectors.toList());
        return labelsListFull;
    }

    public RatingsFullPage clickClearAllLink() {
        clearAllLink.click();
        return this;
    }

    public String getResultCount() {
        return resultCount.getText();
    }

    public RatingsFullPage clickPriceFilter() {
        priceFilterButton.click();
        return this;
    }

    public String getCancelButtonTextInPriceFilterPopup() {
        return priceLabelsList.get(2).getText();
    }

    public RatingsFullPage enterValueInPriceFilter(String a) {
        inputInPriceFilterPopup.clear();
        inputInPriceFilterPopup.sendKeys(a);
        return this;
    }

    public RatingsFullPage clickViewButtonInPriceFilterPopup() {
        viewButtonInPriceFilterPopup.click();
        return this;
    }

    public List<Integer> getListOfPricesFromRatingsChart() {
        ArrayList<Integer> listOfPrices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String formattedPrice = price.getText().replace("$", "");
            listOfPrices.add(Integer.parseInt(formattedPrice));
        }
        return listOfPrices;
    }

    public RatingsFullPage clickRatedBestFilterButton() {
        ratedBestFilterButton.click();
        return this;
    }

    public String getLabelInRatedBestFilterPopup() {
        return labelInRatedBestFilterPopup.getText();
    }

    public RatingsFullPage selectCheckboxInRatedBestFilterPopup() {
        checkBoxInRatedBestFilterPopup.get(0).click();
        return this;
    }

    public RatingsFullPage clickViewButtonInRatedBestFilterPopup() {
        viewButtonInRatedBestFilterPopup.click();
        return this;
    }

    public String getColorOfRatedBestFilterButton() {
        return ratedBestFilterButton.getCssValue("background-color");
    }

    public RatingsFullPage clickMoreFilterButton() {
        moreFilterButton.click();
        return this;
    }

    public RatingsFullPage selectEurekaBrandCheckboxInMoreFilterPopup() {
        eurekaBrandCheckboxInMoreFilterPopup.click();
        return this;
    }

    public RatingsFullPage clickViewButtonInMoreFilterpopup() {
        viewButtonInMoreFilterPopup.click();
        return this;
    }

    public List<String> getBrandsAndModelsListInRatingsChart() {
        List<String> brandsAndModelsListFull = brandsAndModelsList.stream().map(WebElement::getText).collect(Collectors.toList());
        return brandsAndModelsListFull;
    }

    public boolean isRatingsFullViewDisplayed() {
        return ratingsFullView.isDisplayed();
    }

    public RatingsFullPage clickAddToCompareButton() {
        compareButtons.get(0).click();
        return this;
    }

    public String getCompareCircleNumber() {
        waitForElementVisible(compareCircleNumber);
        return compareCircleNumber.getText();
    }

    public RatingsFullPage clickCompareBucketButton() {
        compareBucketButton.click();
        return new RatingsFullPage(driver);
    }

    public ComparePage clickViewCompareButton() {
        viewCompareButton.click();
        return new ComparePage(driver);
    }
}
