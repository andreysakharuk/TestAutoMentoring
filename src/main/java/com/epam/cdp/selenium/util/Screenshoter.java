package com.epam.cdp.selenium.util;

import com.epam.cdp.logging.CrLogger;
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
        try {
            String screenshotPath = SCREENSHOTS_NAME_TPL + RandomNumberUtils.getRandomInt() + ".png";
            takeScreenshot(screenshotPath);
            sendScreenshotToReportPortal(screenshotPath);
        } catch (IOException e) {
            CrLogger.error("Failed to make screenshot");
        }
    }

    private static void takeScreenshot(String screenshotPath) throws IOException {
        WebDriver driver = WebDriverProviderSingleton.getInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File copy = new File(screenshotPath);
        FileUtils.copyFile(screenshot, copy);
    }

    private static void sendScreenshotToReportPortal(String screenshotPath) throws IOException {
        CrLogger.info("Saving screenshot into: " + screenshotPath);
        ReportPortalMessage message = new ReportPortalMessage(new File(screenshotPath), "Screenshot");
        CrLogger.info(message);
    }
}