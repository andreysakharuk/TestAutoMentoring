package com.epam.cdp.selenium.util;

import com.epam.cdp.reporting.CrLogger;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshoter {

    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";

    public static void takeScreenshot() {
        WebDriver driver = WebDriverProviderSingleton.getInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + RandomNumberUtils.getRandomInt();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            String path = screenshotName + ".png";
            CrLogger.info("Saving screenshot into: " + screenshotName);
            ReportPortalMessage message = new ReportPortalMessage(new File(path), "Screnshot");
            CrLogger.LOGGER.info(message);
        } catch (IOException e) {
            CrLogger.error("Failed to make screenshot");
        }
    }
}