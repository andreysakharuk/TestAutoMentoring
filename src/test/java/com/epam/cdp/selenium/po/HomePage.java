package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

    @FindBy(css = "")
    private WebElement l;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
}
