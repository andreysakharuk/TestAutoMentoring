package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ScenarioHooks {
    @Before
    public void beforeScenario(){
        WebDriverProviderSingleton.getInstance();
    }

    @After
    public void afterScenario(){
        WebDriverProviderSingleton.quitDriver();
    }
}
