package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndToEndTests {

    private WebDriver driver;

    private static final String USERNAME = "pwitest";
    private static final String PASSWORD = "Password1";
    private static final String CTA_BANNER_RATINGS = "Get Ratings & Reviews for the Products You Want";
    private static final String CTA_BANNER_OVERVIEW = "Clear through the clutter when choosing the best vacuums.";
    private static final String MIELE_MODEL = "Miele Dynamic U1 Cat & Dog";
    private static final Integer COMPACT_VIEW_ICON = 1;
    private static final Integer FULL_VIEW_ICON = 0;
    private static final Integer FIRST_CHECKBOX = 0;

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
        String actualTextOfCtaBanner = ratingsFullPage.open()
                .getCtaBannerText();
        Assert.assertEquals(actualTextOfCtaBanner, CTA_BANNER_RATINGS);

        LoginPage loginPage = ratingsFullPage.clickSignInButton();
        Assert.assertTrue(loginPage.isSignInButtonDisplayed());

        ratingsFullPage = loginPage.enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickSignInButton(RatingsFullPage.class);
        Assert.assertFalse(ratingsFullPage.isCtaBannerDisplayed());

        ratingsFullPage.clickRecommendedToggle();
        ratingsFullPage.getLabelsListFromRatingsChart().forEach(label -> {
            assertThat(label, either(containsString("RECOMMENDED")).or(containsString("BEST BUY")));
        });

        String resultCount = ratingsFullPage.clickClearAllLink()
                .getResultCounter();
        Assert.assertEquals(resultCount, "12");

        String isCancelButtonDisplayed = ratingsFullPage.clickPriceFilterButton()
                .getCancelButtonTextInPriceFilterPopup();
        Assert.assertEquals(isCancelButtonDisplayed, "CANCEL");

        ratingsFullPage.enterValueInPriceFilterPopup("100")
                .clickViewButtonInPriceFilterPopup();
        assertThat(ratingsFullPage.getPricesListFromRatingsChart(), everyItem(lessThanOrEqualTo(100)));

        String actualLabelFromRatedBestFilter = ratingsFullPage.clickRatedBestFilterButton()
                .getLabelInRatedBestFilterPopup();
        Assert.assertEquals(actualLabelFromRatedBestFilter, "Select One or More Filters:");

        ratingsFullPage.selectCheckboxInRatedBestFilterPopup(FIRST_CHECKBOX)
                .clickViewButtonInRatedBestFilterPopup();
        Assert.assertEquals(ratingsFullPage.getColorOfRatedBestFilterButton(), "rgba(0, 174, 77, 1)");

        ratingsFullPage.clickMoreFilterButton()
                .selectEurekaBrandCheckboxInMoreFilterPopup()
                .clickViewButtonInMoreFilterPopup();

        assertThat(ratingsFullPage.getBrandsAndModelsListInRatingsChart(), everyItem(containsString("Eureka")));
    }

    @Test
    public void checkShopToAmazon() {
        OverviewPage overviewPage = new OverviewPage(driver);
        String heroSectionText = overviewPage.open()
                .getHeroSectionText();
        assertThat(heroSectionText, containsString(CTA_BANNER_OVERVIEW));

        RatingsCompactPage ratingsCompactPage = overviewPage.clickUprightLinkInTypeSection();
        assertThat(ratingsCompactPage.getCtaBannerText(), equalTo(CTA_BANNER_RATINGS));

        MembershipPage membershipPage = ratingsCompactPage.clickBecomeMemberLink();
        assertThat(membershipPage.getCtaBanner(), equalToIgnoringWhiteSpace(
                "Buying smart is just the start"));

        new Browser(driver).navigateBack();
        assertThat(ratingsCompactPage.getCounterResult(), equalTo("64"));

        ModelPage modelpage = ratingsCompactPage.clickShopButton();
        Assert.assertTrue(modelpage.isPriceAndShopTitleDisplayed());

        AmazonPage amazonPage = modelpage.clickAmazonButton();
        assertThat(amazonPage.getUrl(), containsString("amazon.com"));
    }

    @Test
    public void checkLoginOnBuyingGuide() {
        ModelPage modelPage = new ModelPage(driver);
        OverviewPage overviewPage = modelPage.open()
                .clickUprightVacuumsLinkInBreadcrumbs();
        assertThat(overviewPage.getHeroSectionText(), containsString(CTA_BANNER_OVERVIEW));

        BuyingGuidePage buyingGuidePage = overviewPage.clickBuyingGuideLink();
        String labelInHeroSection = buyingGuidePage.getLabelInHeroSectionText();
        assertThat(labelInHeroSection, equalTo("Vacuum Buying Guide"));

        LoginPage loginPage = buyingGuidePage.clickSignInButton();
        Assert.assertTrue(loginPage.isSignInButtonDisplayed());

        buyingGuidePage = loginPage.enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickSignInButton(BuyingGuidePage.class);
        Assert.assertFalse(buyingGuidePage.isLockNearRecommendedLinkDisplayed());
    }

    @Test
    public void checkAddingModelsToComparision() {
        HomePage homePage = new HomePage(driver).open();
        Assert.assertTrue(homePage.isMainArticlesSectionDisplayed());

        LoginPage loginPage = homePage.clickSignInButton();
        homePage = loginPage.enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickSignInButton(HomePage.class);
        Assert.assertEquals(homePage.getAccountInfoSectionText(), "resault1");

        SearchResultPage searchResultPage = homePage.enterValueInSearchInput(MIELE_MODEL, "value")
                .clickSearchButton();
        assertThat(searchResultPage.getListOfBrands(), everyItem(startsWith("Miele")));

        ModelPage modelPage = searchResultPage.clickFirstResult();
        assertThat(modelPage.getTitle(), equalTo(MIELE_MODEL));

        RatingsCompactPage ratingsCompactPage = modelPage.clickIconInSwitcher(RatingsCompactPage.class, COMPACT_VIEW_ICON);
        ratingsCompactPage.clickCloseTourButton();
        Assert.assertTrue(ratingsCompactPage.isRatingsListViewDisplayed());

        ratingsCompactPage.clickAddToCompareButton();
        assertThat(ratingsCompactPage.getCompareCircleNumber(), equalTo("1"));

        RatingsFullPage ratingsFullPage = ratingsCompactPage.clickIconInSwitcher(RatingsFullPage.class, FULL_VIEW_ICON);
        Assert.assertTrue(ratingsFullPage.isRatingsFullViewDisplayed());

        ratingsFullPage.clickAddToCompareButton();
        assertThat(ratingsFullPage.getCompareCircleNumber(), equalTo("2"));

        ComparePage comparePage = ratingsFullPage.clickCompareBucketButton()
                .clickViewCompareButton();
        assertThat(comparePage.getModelsList().get(0), equalTo(MIELE_MODEL));
        assertThat(comparePage.getModelsList().get(1), equalTo("Kenmore Elite Pet Friendly 31150"));

        comparePage.clickRemoveButton()
                .clickRemoveButton();
        assertThat(comparePage.getLabelFromEmptyPage(), equalTo("Your Compare Chart is Empty!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
