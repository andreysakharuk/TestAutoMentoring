package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage {

    @FindBy(id = "main-title")
    private WebElement ctaBanner;

    public MembershipPage(WebDriver driver) {
        super(driver);
    }

    public String getCtaBanner() {
        return ctaBanner.getText();
    }
}