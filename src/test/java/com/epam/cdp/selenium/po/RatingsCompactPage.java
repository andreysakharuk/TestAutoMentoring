package com.epam.cdp.selenium.po;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RatingsCompactPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='cta-top-content__buttons text-center']")
    private WebElement becomeAmemberLink;

    @FindBy(className = "cta-top-content__header")
    private WebElement ctaButton;

    @FindBy(css = ".spa-page-counter__values >span:nth-child(2)")
    private WebElement resultCount;

    @FindBy(css = ".list__price-and-shop a")
    private List<WebElement> listOfShopButtons;

    @FindBy(className = "list__tour__skip")
    private WebElement closeTourButton;

    @FindBy(css = "div.clearfix.subscriber-list")
    private WebElement ratingsListView;

    @FindBy(css = ".shared-crux-tooltip .compare-icon")
    private List<WebElement> compareButtons;

    @FindBy(xpath = "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']")
    private WebElement compareCircleNumber;

    @FindBy(xpath = "//*[@alt='view']")
    private List<WebElement> switcherIcons;


    public RatingsCompactPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerRatingsCompactPage() {
        return ctaButton.getText();
    }

    public MembershipPage clickOnBecomeAMemberLink() {
        becomeAmemberLink.click();
        return new MembershipPage(driver);
    }

    public String getCounterResult() {
        return resultCount.getText();
    }

    public ModelPage clickOnShopButton() {
        listOfShopButtons.get(0).click();
        return new ModelPage(driver);
    }

    public RatingsCompactPage clickOnCloseTourButton() {
        try {
            closeTourButton.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Product bug");
        }
        return this;
    }

    public boolean isRatingsListViewDisplayed() {
        waitForElementVisible(ratingsListView);
        return isElementDisplayed(ratingsListView);
    }

    public RatingsCompactPage clickOnAddToCompareButton() {
        compareButtons.get(1).click();
        return this;
    }

    public String getCompareCircleNumber() {
        return compareCircleNumber.getText();
    }

    public RatingsFullPage clickOnFullViewIcon() {
        switcherIcons.get(0).click();
        return new RatingsFullPage(driver);
    }
}