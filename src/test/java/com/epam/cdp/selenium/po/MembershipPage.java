package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends AbstractPage {

    @FindBy(id = "main-title")
    private WebElement ctaBanner;

    public MembershipPage(WebDriver driver) {
        super(driver);
    }

    public RatingsCompactPage navigateBack() {
        driver.navigate().back();
        return new RatingsCompactPage(driver);
    }

    public MembershipPage open() {
        driver.get("https://www.consumerreports.org/join?INTKEY=I82RLMS");
        return new MembershipPage(driver);
    }

    public String getCtaBannerMembershipPage() {
        return ctaBanner.getText();
    }
}
