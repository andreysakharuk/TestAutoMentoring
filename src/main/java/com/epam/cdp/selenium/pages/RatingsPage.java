package com.epam.cdp.selenium.pages;

import com.epam.cdp.bo.RatingsView;
import com.epam.cdp.selenium.wait.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RatingsPage extends BasePage {

    @FindBy(xpath = "//*[@alt='view']")
    private List<WebElement> switcherIcons;

    @FindBy(className = "cta-top-content__header")
    private WebElement ctaBanner;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareCircleNumber;

    @FindBy(xpath = "//*[@data-id='price']")
    private WebElement priceFilterButton;

    @FindBy(css = ".price-filter-popover .crux-input")
    private WebElement inputInPriceFilterPopup;

    @FindBy(css = ".price-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInPriceFilterPopup;

    @FindBy(xpath = "//*[@data-id='rated']//button")
    private WebElement ratedBestFilterButton;

    @FindBy(xpath = "//*[@data-id='rated']//p")
    private WebElement labelInRatedBestFilterPopup;

    @FindBy(css = ".shared-crux-checkbox.crux-checkbox label")
    private List<WebElement> checkBoxInRatedBestFilterPopup;

    @FindBy(css = ".rated-filter-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInRatedBestFilterPopup;

    @FindBy(xpath = "//*[@data-id='more-filters']")
    private WebElement moreFilterButton;

    @FindBy(xpath = "//*[@name='Eureka-checkbox']/parent::label")
    private WebElement eurekaBrandCheckboxInMoreFilterPopup;

    @FindBy(css = ".more-filters-popover .crux-btn.crux-btn-primary")
    private WebElement viewButtonInMoreFilterPopup;

    @FindBy(css = "div.vue-slider-dot")
    private WebElement priceSlider;

    @FindBy(xpath = "//div[@class='popover-content']/div[3]//input[@type='checkbox']")
    private List<WebElement> checkboxesInMoreFilterPopup;

    @FindBy(xpath = "//div[@class='popover-content']/div[3]//input[@type='checkbox']/parent::label")
    private List<WebElement> checkboxesLabelsInMoreFilterPopup;


    public RatingsPage(WebDriver driver) {
        super(driver);
    }

    public <T extends RatingsPage> T clickIconInSwitcher(Class<T> pageClass, RatingsView ratingsView) {
        switcherIcons.get(ratingsView.getPosition()).click();
        return generatePage(pageClass);
    }

    public String getCtaBannerText() {
        return ctaBanner.getText();
    }

    public boolean isCtaBannerDisplayed() {
        return isElementDisplayed(ctaBanner);
    }

    public String getCompareCircleNumber() {
        new Waiter().waitForElementVisible(compareCircleNumber);
        return compareCircleNumber.getText();
    }

    public RatingsPage clickPriceFilterButton() {
        priceFilterButton.click();
        return this;
    }

    public RatingsPage enterValueInPriceFilterPopup(String a) {
        inputInPriceFilterPopup.clear();
        inputInPriceFilterPopup.sendKeys(a);
        return this;
    }

    public RatingsPage clickViewButtonInPriceFilterPopup() {
        viewButtonInPriceFilterPopup.click();
        return this;
    }

    public RatingsPage clickRatedBestFilterButton() {
        ratedBestFilterButton.click();
        return this;
    }

    public String getColorOfRatedBestFilterButton() {
        return ratedBestFilterButton.getCssValue("background-color");
    }

    public String getLabelInRatedBestFilterPopup() {
        return labelInRatedBestFilterPopup.getText();
    }

    public RatingsPage selectCheckboxInRatedBestFilterPopup(Integer checkboxNumber) {
        checkBoxInRatedBestFilterPopup.get(checkboxNumber).click();
        return this;
    }

    public RatingsPage clickViewButtonInRatedBestFilterPopup() {
        viewButtonInRatedBestFilterPopup.click();
        return this;
    }

    public RatingsPage clickMoreFilterButton() {
        moreFilterButton.click();
        return this;
    }

    public RatingsPage selectBrandCheckboxInMoreFilterPopup(String brandCheckbox) {
        int indexOfCheckbox = -1;
        for (WebElement names: checkboxesInMoreFilterPopup){
            if (names.getAttribute("name").contains(brandCheckbox)){
                indexOfCheckbox = checkboxesInMoreFilterPopup.indexOf(names);
            }
        }
        checkboxesLabelsInMoreFilterPopup.get(indexOfCheckbox).click();
        return this;
    }

    public RatingsPage clickViewButtonInMoreFilterPopup() {
        viewButtonInMoreFilterPopup.click();
        return this;
    }

    public RatingsPage movePriceSlider() {
        new Waiter().waitForElementVisible(viewButtonInPriceFilterPopup);
        new Actions(driver).dragAndDropBy(priceSlider, -200, 0).build().perform();
        return this;
    }
}
