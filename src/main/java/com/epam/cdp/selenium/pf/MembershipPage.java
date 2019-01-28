package com.epam.cdp.selenium.pf;

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

    public String getCtaBannerMembershipPage() {
        return ctaBanner.getText();
    }
}
