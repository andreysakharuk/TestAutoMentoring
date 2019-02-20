package com.epam.cdp.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage {

    @FindBy(id = "main-title")
    private WebElement ctaBanner;

    public MembershipPage() {
        super();
    }

    public String getCtaBanner() {
        return ctaBanner.getText();
    }
}
