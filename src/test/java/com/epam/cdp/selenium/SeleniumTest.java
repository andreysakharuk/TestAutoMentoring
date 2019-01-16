package com.epam.cdp.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void testConsumer(){
//        System.setProperty("webdriver.chrome.driver", "libs/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.consumerreports.org/cro/index.htm");
        Assert.assertTrue(true);
        driver.quit();
    }
}
