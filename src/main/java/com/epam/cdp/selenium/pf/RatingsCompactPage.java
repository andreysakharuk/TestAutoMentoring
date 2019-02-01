package com.epam.cdp.selenium.pf;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RatingsCompactPage extends RatingsPage {

    @FindBy(xpath = "//*[@class='cta-top-content__buttons text-center']")
    private WebElement becomeMemberLink;

    @FindBy(css = ".spa-page-counter__values >span:nth-child(2)")
    private WebElement resultCount;

    @FindBy(css = ".list__price-and-shop a")
    private List<WebElement> shopButtons;

    @FindBy(className = "list__tour__skip")
    private WebElement closeTourButton;

    @FindBy(css = "div.clearfix.subscriber-list")
    private WebElement ratingsListView;

    @FindBy(css = ".shared-crux-tooltip .compare-icon")
    private List<WebElement> compareButtons;


    public RatingsCompactPage(WebDriver driver) {
        super(driver);
    }


    public MembershipPage clickBecomeMemberLink() {
        becomeMemberLink.click();
        return new MembershipPage(driver);
    }

    public String getCounterResult() {
        return resultCount.getText();
    }

    public ModelPage clickShopButton() {
        shopButtons.get(0).click();
        return new ModelPage(driver);
    }

    public RatingsCompactPage clickCloseTourButton() {
        try {
            closeTourButton.click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Product bug");
        }
        return this;
    }

    public boolean isRatingsListViewDisplayed() {
        return isElementDisplayed(ratingsListView);
    }

    public RatingsCompactPage clickAddToCompareButton() {
        compareButtons.get(1).click();
        return this;
    }
}