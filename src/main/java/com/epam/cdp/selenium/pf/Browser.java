package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver driver;

    public Browser(WebDriver driver){
        this.driver = driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

}
