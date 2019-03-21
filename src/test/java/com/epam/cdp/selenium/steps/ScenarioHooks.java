package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.driver.WebDriverCustomDecorator;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;


public class ScenarioHooks {

    private WebDriver driver;

    @Before
    public void beforeScenario(){
        WebDriverProviderSingleton.getInstance();
        WebDriver driver1 = WebDriverProviderSingleton.getInstance();
        driver = new WebDriverCustomDecorator(driver1);
    }

    @After
    public void afterScenario(){
        WebDriverProviderSingleton.quitDriver();
    }
}
