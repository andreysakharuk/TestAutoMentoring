package com.epam.cdp.selenium.pf;

import com.epam.cdp.selenium.Browser;
import com.epam.cdp.selenium.util.ListGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RatingsFullPage extends RatingsPage {

    private static final String RATINGS_FULL_PAGE_URL = "https://www.consumerreports.org/products/vacuum-cleaners/handheld-vacuum/view1/";

    @FindBy(className = "recommended-switcher__value")
    private WebElement recommendedToggle;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']//*[@class='recommendation-label']")
    private List<WebElement> labelsList;

    @FindBy(className = "ratings-spa-filters__clear-filters")
    private WebElement clearAllLink;

    @FindBy(css = ".spa-page-counter__values >span:nth-child(2)")
    private WebElement resultCounter;

    @FindBy(css = ".price-filter-popover .crux-label-style")
    private List<WebElement> priceLabelsList;

    @FindBy(css = ".classic-view__price .crux-green")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//*[@class='clearfix classic-view__body__item classic-view__body__item--fixed']")
    private List<WebElement> brandsAndModelsList;

    @FindBy(css = "div.classic-view")
    private WebElement ratingsFullView;

    @FindBy(css = ".shared-crux-tooltip .compare-icon")
    private List<WebElement> compareButtons;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareBucketButton;

    @FindBy(xpath = "//*[@data-display='true']//button[@class='crux-btn crux-btn-special--lg']")
    private WebElement viewCompareButton;

    @FindBy(xpath = "//*[@style='border-radius: 0px; background-color: rgb(0, 0, 0); transition-duration: 0s; width: 153.636px; left: 0px;']")
    private WebElement priceBar;

    @FindBy(css = "input.crux-input")
    private WebElement priceInput;

    @FindBy(css = ".scroller__bar")
    private WebElement ratingsSlider;

    @FindBy(css = ".classic-view__header__item :nth-child(2)")
    private WebElement specsHeader;

    public RatingsFullPage(WebDriver driver) {
        super(driver);
    }

    public RatingsFullPage open() {
        driver.get(RATINGS_FULL_PAGE_URL);
        return new RatingsFullPage(driver);
    }

    public RatingsFullPage clickRecommendedToggle() {
        recommendedToggle.click();
        return this;
    }

    public List<String> getLabelsListFromRatingsChart() {
        return new ListGenerator().getList(labelsList);
    }

    public RatingsFullPage clickClearAllLink() {
        clearAllLink.click();
        return this;
    }

    public String getResultCounter() {
        return resultCounter.getText();
    }

    public List<Integer> getPricesListFromRatingsChart() {
        List<Integer> pricesListFull = new ArrayList<>();
        for (WebElement price : pricesList) {
            String formattedPrice = price.getText().replace("$", "");
            pricesListFull.add(Integer.parseInt(formattedPrice));
        }
        return pricesListFull;
    }

    public List<String> getBrandsAndModelsListInRatingsChart() {
        return new ListGenerator().getList(brandsAndModelsList);
    }

    public boolean isRatingsFullViewDisplayed() {
        return ratingsFullView.isDisplayed();
    }

    public RatingsFullPage clickAddToCompareButton() {
        compareButtons.get(0).click();
        return this;
    }

    public RatingsFullPage clickCompareBucketButton() {
        compareBucketButton.click();
        return new RatingsFullPage(driver);
    }

    public ComparePage clickViewCompareButton() {
        viewCompareButton.click();
        return new ComparePage(driver);
    }


    public String getPriceInputInFilterPopup() {
        waitForElementVisible(priceInput);
        return priceInput.getAttribute("value");
    }

    public RatingsFullPage moveRatingsSlider() {
        waitForElementVisible(ratingsSlider);
        new Actions(driver).dragAndDropBy(ratingsSlider, 300, 0).build().perform();
        return this;
    }

    public boolean isSpecsHeaderDisplayedInRatingsChart() {
        return isElementDisplayed(specsHeader);
    }

    public void highlightRatingsSlider() {
        new Browser(driver).highlightElement(ratingsSlider);
    }
}
