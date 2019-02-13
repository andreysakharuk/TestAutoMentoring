package com.epam.cdp.selenium.pf;

import com.epam.cdp.bo.User;
import com.epam.cdp.driver.Driver;
import com.epam.cdp.selenium.Browser;
import com.epam.cdp.selenium.steps.FilterServices;
import com.epam.cdp.selenium.steps.LoginServices;
import com.epam.cdp.selenium.steps.SearchServices;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndToEndTests {

    private WebDriver driver;
    private User user;
    private LoginServices loginServices;
    private SearchServices searchServices;
    private FilterServices filterServices;

    private static final String CTA_BANNER_RATINGS = "Get Ratings & Reviews for the Products You Want";
    private static final String CTA_BANNER_OVERVIEW = "Clear through the clutter when choosing the best vacuums.";
    private static final String MIELE_MODEL = "Miele Dynamic U1 Cat & Dog";
    private static final String EUREKA_BRAND = "Eureka";
    private static final Integer FIRST_CHECKBOX = 0;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        this.driver = new Driver().initDriver();
        this.user = new User();
        this.loginServices = new LoginServices();
        this.searchServices = new SearchServices();
        this.filterServices = new FilterServices();
    }

    @Test
    public void checkFiltersOnRatingsFullPage() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage(driver);
        String actualTextOfCtaBanner = ratingsFullPage.open()
                .getCtaBannerText();
        Assert.assertEquals(actualTextOfCtaBanner, CTA_BANNER_RATINGS);

        loginServices.doLogin(driver, user);
        Assert.assertFalse(ratingsFullPage.isCtaBannerDisplayed());

        ratingsFullPage.clickRecommendedToggle();
        ratingsFullPage.getLabelsListFromRatingsChart().forEach(label -> {
            assertThat(label, either(containsString("RECOMMENDED")).or(containsString("BEST BUY")));
        });

        String resultCount = ratingsFullPage.clickClearAllLink()
                .getResultCounter();
        Assert.assertEquals(resultCount, "12");

        filterServices.doPriceFiltering(ratingsFullPage, "100");
        assertThat(ratingsFullPage.getPricesListFromRatingsChart(), everyItem(lessThanOrEqualTo(100)));

        filterServices.doRatedBestFiltering(ratingsFullPage, FIRST_CHECKBOX);
        assertThat(ratingsFullPage.getColorOfRatedBestFilterButton(), containsString("0, 174, 77"));

        filterServices.doMoreFiltering(ratingsFullPage, EUREKA_BRAND);
        assertThat(ratingsFullPage.getBrandsAndModelsListInRatingsChart(), everyItem(containsString(EUREKA_BRAND)));
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
        assertThat(ratingsCompactPage.getCounterResult(), equalTo("75"));

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

        loginServices.doLogin(driver, user);
        Assert.assertFalse(buyingGuidePage.isLockNearRecommendedLinkDisplayed());
    }

    @Test
    public void checkAddingModelsToComparision() {
        HomePage homePage = new HomePage(driver).open();
        Assert.assertTrue(homePage.isMainArticlesSectionDisplayed());

        loginServices.doLogin(driver, user);
        Assert.assertEquals(homePage.getAccountInfoSectionText(), "resault1");

        searchServices.doSearch(homePage, driver, "value", MIELE_MODEL);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.waitTextToAppearInLabel("Showing results for Miele Dynamic U1 Cat");
        assertThat(searchResultPage.getListOfBrands(), everyItem(startsWith("Miele")));

        ModelPage modelPage = searchResultPage.clickFirstResult();
        assertThat(modelPage.getTitle(), equalTo(MIELE_MODEL));

        RatingsCompactPage ratingsCompactPage = modelPage.clickIconInSwitcher(RatingsCompactPage.class, RatingsView.COMPACT);
        ratingsCompactPage.clickCloseTourButton();
        Assert.assertTrue(ratingsCompactPage.isRatingsListViewDisplayed());

        ratingsCompactPage.clickAddToCompareButton();
        assertThat(ratingsCompactPage.getCompareCircleNumber(), equalTo("1"));

        RatingsFullPage ratingsFullPage = ratingsCompactPage.clickIconInSwitcher(RatingsFullPage.class, RatingsView.FULL);
        Assert.assertTrue(ratingsFullPage.isRatingsFullViewDisplayed());

        ratingsFullPage.clickAddToCompareButton();
        assertThat(ratingsFullPage.getCompareCircleNumber(), equalTo("2"));

        ComparePage comparePage = ratingsFullPage.clickCompareBucketButton()
                .clickViewCompareButton();
        assertThat(comparePage.getModelsList().get(1), equalTo("Shark Navigator Powered Lift-Away NV586 (Target)"));
        assertThat(comparePage.getModelsList().get(0), equalTo("Kenmore Elite Pet Friendly 31150"));


        comparePage.clickRemoveButton()
                .clickRemoveButton();
        assertThat(comparePage.getLabelFromEmptyPage(), equalTo("Your Compare Chart is Empty!"));
    }

    @Test
    public void checkPriceFilter() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage(driver);
        ratingsFullPage.open();
        loginServices.doLogin(driver, user);
        ratingsFullPage.clickPriceFilterButton();
        String defaultPrice = ratingsFullPage.getPriceInputInFilterPopup();
        ratingsFullPage.movePriceSlider();
        Assert.assertNotEquals(ratingsFullPage.getPriceInputInFilterPopup(), defaultPrice);
    }

    @Test
    public void checkRatingsSliderScroll() throws InterruptedException {
        RatingsFullPage ratingsFullPage = new RatingsFullPage(driver);
        ratingsFullPage.open();
        loginServices.doLogin(driver, user);
        Thread.sleep(5000);
        ratingsFullPage.moveRatingsSlider().highlightRatingsSlider();
        Assert.assertTrue(ratingsFullPage.isSpecsHeaderDisplayedInRatingsChart());
    }

    @Test
    public void checkRatingsJsScroll() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage(driver);
        ratingsFullPage.open();
        loginServices.doLogin(driver, user);
        new Browser(driver).scrollToBottomOfPage();
        HomePage homePage = ratingsFullPage.crLogoClick();
        Assert.assertEquals(homePage.getAccountInfoSectionText(), "resault1");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

