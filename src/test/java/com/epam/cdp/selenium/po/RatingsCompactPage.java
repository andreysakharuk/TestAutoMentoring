package com.epam.cdp.selenium.po;

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

    public RatingsCompactPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBannerRatingsCompactPage(){
        return ctaButton.getText();
    }

    public MembershipPage clickOnBecomeAMemberLink(){
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


}