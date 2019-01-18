package com.epam.cdp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.consumerreports.org/cro/index.htm";
    private static final String MAIN_ARTICLES_SECTION = ".main-articles__main-article--desktop";
    private static final String SIGN_IN_BUTTON_GLOBAL_NAV = "gnav-sign-in";
    private static final String USERNAME_INPUT = "userName";
    private static final String USERNAME = "pwitest";
    private static final String PASSWORD_INPUT = "password";
    private static final String PASSWORD = "Password1";
    private static final String SIGN_IN_BUTTON_POPUP = "//input[@value='Sign In']";
    private static final String SIGN_IN_FORM = ".gnav-sign-in__form__title";
    private static final String ACCOUNT_INFO_SECTION = ".account-info";
    private static final String USERNAME_ACCOUNT = "resault1";
    private static final String SEARCH_FIELD = "//input[@title='Search']";
    private static final String MIELE_MODEL_NAME = "Miele Dynamic U1 Cat & Dog";
    private static final String SEARCH_BUTTON = ".gnav-typeahead__button";
    private static final String SEARCH_RESULT_LABEL = "search-top";
    private static final String SEARCH_RESULT_TEXT = "Showing results for Miele Dynamic U1 Cat";
    private static final String MODELS_BRAND_ = ".product-brand";
    private static final String MIELE_BRAND = "Miele";
    private static final String MODEL_TITLE = "span.crux-page-title";
    private static final String SWITCHER_ICONS = "//*[@alt='view']";
    private static final String CLOSE_BUTTON_TOUR = "list__tour__close__label";
    private static final String RATINGS_TITLE = "h1.crux-page-title";
    private static final String RATINGS_LIST = "div.list";
    private static final String COMPARE_BUTTONS = ".shared-crux-tooltip .compare-icon";
    private static final String COMPARE_CIRCLE_NUMBER =
            "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']";
    private static final String RATINGS_FULL = "div.classic-view";
    private static final String COMPARE_BUCKET =
            "//*[@data-id='compare-bucket']//*[@data-q-check='shared-crux-number-score']";
    private static final String VIEW_COMPARE_BUTTON =
            "//*[@data-display='true']//*[contains(text(), 'View Compare')]";
    private static final String MODELS_ON_COMPARE = ".compare-page__model-name";
    private static final String KENMORE_MODEL_NAME = "Kenmore Elite Pet Friendly 31150";
    private static final String REMOVE_BUTTON_ON_COMPARE = "//span[contains(text(), 'Remove')]";
    private static final String EMPTY_PAGE_LABEL = ".crux-call-to-action";
    private static final String EMPTY_PAGE_LABEL_TEXT = "Your Compare Chart is Empty!";


    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testConsumer() {
// 1 step
        driver.get(HOME_PAGE_URL);
        Assert.assertTrue(driver.findElement(By.cssSelector(MAIN_ARTICLES_SECTION)).isDisplayed());
    }
// 2 step
@Test(priority = 2)
public void testConsumer2() {
    driver.findElement(By.className(SIGN_IN_BUTTON_GLOBAL_NAV)).click();
    driver.findElement(By.name(USERNAME_INPUT)).sendKeys(USERNAME);
    driver.findElement(By.name(PASSWORD_INPUT)).sendKeys(PASSWORD);
    driver.findElement(By.xpath(SIGN_IN_BUTTON_POPUP)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(SIGN_IN_FORM)));
    Assert.assertEquals(driver.findElement(By.cssSelector(ACCOUNT_INFO_SECTION)).getText(),
            USERNAME_ACCOUNT);
}
// 3 step
@Test(priority = 3)
public void testConsumer34() {
    driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(MIELE_MODEL_NAME);

    new WebDriverWait(driver, 10)
            .until(ExpectedConditions.attributeContains(By.xpath(SEARCH_FIELD), "value", MIELE_MODEL_NAME));
    driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
    new WebDriverWait(driver, 5)
            .until(ExpectedConditions.textToBePresentInElementLocated(By.id(SEARCH_RESULT_LABEL),
                    SEARCH_RESULT_TEXT));
    List<WebElement> listOfBrands = driver.findElements(By.cssSelector(MODELS_BRAND_));
    assertThat(listOfBrands, hasSize(5));
    for (WebElement element : listOfBrands) {
        assertThat(element.getText(), startsWith(MIELE_BRAND));
    }

// 4 step
    listOfBrands.get(0).click();
    assertThat(driver.findElement(By.cssSelector(MODEL_TITLE)).getText(),
            is(equalTo(MIELE_MODEL_NAME)));
}

    @Test(priority = 5)
    public void testConsumer5() {
// 5 step
        driver.findElements(By.xpath(SWITCHER_ICONS)).get(1).click();
        driver.findElement(By.className(CLOSE_BUTTON_TOUR)).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(RATINGS_TITLE)));
        Assert.assertTrue(driver.findElement(By.cssSelector(RATINGS_LIST)).isDisplayed());
    }
    @Test(priority = 6)
    public void testConsumer6() {
// 6 step
        driver.findElements(By.cssSelector(COMPARE_BUTTONS)).get(1).click();
        assertThat(driver.findElement(By.xpath(COMPARE_CIRCLE_NUMBER))
                .getText(), is(equalTo("1")));
    }
    @Test(priority = 7)
    public void testConsumer7() {
//7 step
        driver.findElements(By.xpath(SWITCHER_ICONS)).get(0).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(RATINGS_FULL)).isDisplayed());
    }
    @Test(priority = 8)
    public void testConsumer8() {
// 8 step
        driver.findElements(By.cssSelector(COMPARE_BUTTONS)).get(0).click();
        assertThat(driver.findElement(By.xpath(COMPARE_CIRCLE_NUMBER))
                .getText(), is(equalTo("2")));
    }
    @Test(priority = 9)
    public void testConsumer9() {
// 9 step
        driver.findElement(By.xpath(COMPARE_BUCKET)).click();
        driver.findElement(By.xpath(VIEW_COMPARE_BUTTON)).click();

        List<WebElement> listOfModels = driver.findElements(By.cssSelector(MODELS_ON_COMPARE));
        assertThat(listOfModels, hasSize(2));
        assertThat(listOfModels.get(0).getText(), is(equalTo(MIELE_MODEL_NAME)));
        assertThat(listOfModels.get(1).getText(), is(equalTo(KENMORE_MODEL_NAME)));
    }
    @Test(priority = 10)
    public void testConsumer10() {
//10 step
        driver.findElement(By.xpath(REMOVE_BUTTON_ON_COMPARE)).click();
        driver.findElement(By.xpath(REMOVE_BUTTON_ON_COMPARE)).click();
        assertThat(driver.findElement(By.cssSelector(EMPTY_PAGE_LABEL)).getText(),
                is(equalTo(EMPTY_PAGE_LABEL_TEXT)));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
