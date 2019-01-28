package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndToEndTest {

    private WebDriver driver;

    private static final String USERNAME = "pwitest";
    private static final String PASSWORD = "Password1";
    private static final String CTA_BANNER_RATINGS = "Get Ratings & Reviews for the Products You Want";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void checkFiltersOnRatingsFullPage() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage(driver);
        String actualTextOfCtaBanner = ratingsFullPage.open().getCtaBannerRatingsFullPage();
        Assert.assertEquals(actualTextOfCtaBanner, CTA_BANNER_RATINGS);

        LoginPage loginPage = ratingsFullPage.open().clickOnSignInButtonInGlobalNav();
        Assert.assertTrue(loginPage.isSignInButtonDisplayed());

        ratingsFullPage = loginPage.enterUsername(USERNAME).enterPassword(PASSWORD).clickSignInButtonInLoginForm();
        Assert.assertFalse(ratingsFullPage.isCtaBannerDisplayed());

        ratingsFullPage.clickOnRecommendedToggle();
        ArrayList<String> listOfLabels = ratingsFullPage.getListOfLabelsFromRatingsChart();
        for (String label : listOfLabels) {
            assertThat(label, either(containsString("RECOMMENDED")).or(containsString("BEST BUY")));
        }

        String resultCount = ratingsFullPage.clickOnClearAllLink().getResultCount();
        Assert.assertEquals(resultCount, "12");

        String isCancelButtonDisplayed = ratingsFullPage.clickOnPriceFilter().getCancelButtonInPriceFilter();
        Assert.assertEquals(isCancelButtonDisplayed, "CANCEL");

        ratingsFullPage.enterValueInPriceFilter("100").clickOnViewButtonInPriceFilter();
        ArrayList<Integer> listOfPrices = ratingsFullPage.getListOfPricesFromRatingsChart();
        assertThat(listOfPrices, everyItem(lessThanOrEqualTo(100)));

        String actualLabelFromRatedBestFilter = ratingsFullPage.clickOnRatedBestFilter().getLabelFromRatedBestFilter();
        Assert.assertEquals(actualLabelFromRatedBestFilter, "Select One or More Filters:");

        ratingsFullPage.selectCheckboxInRatedBestFilter().clickOnViewButtonInRatedBestFilter();
        Assert.assertEquals(ratingsFullPage.getColorOfRatedBestFilter(), "rgba(0, 174, 77, 1)");

        ratingsFullPage.clickOnMoreFilter().selectEurekaBrandCheckboxInMoreFilter().clickOnViewButtonInMoreFilter();

        ArrayList<String> listOfBrandsAndModels = ratingsFullPage.getListOfBrandsAndModelsFromRatingsChart();
        assertThat(listOfBrandsAndModels, everyItem(containsString("Eureka")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
