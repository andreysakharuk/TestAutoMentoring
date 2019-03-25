package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.assertion.CustomAssertion;
import com.epam.cdp.assertion.CustomHamcrestAssertion;
import com.epam.cdp.bo.RatingsView;
import com.epam.cdp.bo.User;
import com.epam.cdp.bo.UserFactory;
import com.epam.cdp.logging.CrLogger;
import com.epam.cdp.selenium.Browser;
import com.epam.cdp.selenium.driver.WebDriverCustomDecorator;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.epam.cdp.selenium.services.FilterServices;
import com.epam.cdp.selenium.services.LoginServices;
import com.epam.cdp.selenium.services.SearchServices;
import com.epam.cdp.selenium.util.Screenshoter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class EndToEndTests {

    private WebDriver driver;
    private LoginServices loginServices;
    private SearchServices searchServices;
    private FilterServices filterServices;
    private Browser browser;
    private User user;

    private static final String CTA_BANNER_RATINGS = "Get Ratings & Reviews for the Products You Want";
    private static final String CTA_BANNER_OVERVIEW = "Clear through the clutter when choosing the best vacuums.";
    private static final String MIELE_MODEL = "Miele Dynamic U1 Cat & Dog";
    private static final String EUREKA_BRAND = "Eureka";
    private static final Integer FIRST_CHECKBOX = 0;

    @BeforeClass
    public void setUp() {
        this.loginServices = new LoginServices();
        this.searchServices = new SearchServices();
        this.filterServices = new FilterServices();
        this.user = UserFactory.getValidUser();
    }

    @BeforeMethod
    public void setUpDriver(){
        WebDriver driver1 = WebDriverProviderSingleton.getInstance();
        driver = new WebDriverCustomDecorator(driver1);
        this.browser = new Browser();
        CrLogger.info("TEST STARTS");
    }

    @Test(description = "Filter feature")
    public void checkFiltersOnRatingsFullPage() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage();
        String actualTextOfCtaBanner = ratingsFullPage.open()
                                                      .getCtaBannerText();
        new CustomAssertion("Checking text of CTA banner").assertEquals(actualTextOfCtaBanner, CTA_BANNER_RATINGS);

        loginServices.doLogin(user);
        new CustomAssertion("Checking CTA banner doesn't appear").assertFalse(ratingsFullPage.isCtaBannerDisplayed());

        ratingsFullPage.clickRecommendedToggle();
        ratingsFullPage.getLabelsListFromRatingsChart().forEach(label -> {
            CustomHamcrestAssertion.assertThat(label, either(containsString("RECOMMENDED")).or(containsString("BEST BUY")),
                    "Checking that all models are Best Buy or Recommended");
        });

        String resultCount = ratingsFullPage.clickClearAllLink()
                                            .getResultCounter();
        new CustomAssertion("Checking number of models").assertEquals(resultCount, "12");

        filterServices.doPriceFiltering("100");
        CustomHamcrestAssertion.assertThat(ratingsFullPage.getPricesListFromRatingsChart(), everyItem(lessThanOrEqualTo(100)),
                "Checking that Price filter applied");

        filterServices.doRatedBestFiltering(FIRST_CHECKBOX);
        CustomHamcrestAssertion.assertThat(ratingsFullPage.getColorOfRatedBestFilterButton(), containsString("0, 174, 77"),
                "Checking that Best filter applied");

        filterServices.doMoreFiltering(EUREKA_BRAND);
        CustomHamcrestAssertion.assertThat(ratingsFullPage.getBrandsAndModelsListInRatingsChart(), everyItem(containsString(EUREKA_BRAND)),
                "Checking that More filter applied");
    }

    @Test(description = "Ratings feature")
    public void checkShopToAmazon() {
        OverviewPage overviewPage = new OverviewPage();
        String heroSectionText = overviewPage.open()
                                             .getHeroSectionText();
        CustomHamcrestAssertion.assertThat(heroSectionText, containsString(CTA_BANNER_OVERVIEW),
                "Checking Hero section contains proper text");

        RatingsCompactPage ratingsCompactPage = overviewPage.clickUprightLinkInTypeSection();
        CustomHamcrestAssertion.assertThat(ratingsCompactPage.getCtaBannerText(), equalTo(CTA_BANNER_RATINGS),
                "Checking CTA banner contains proper text");

        MembershipPage membershipPage = ratingsCompactPage.clickBecomeMemberLink();
        CustomHamcrestAssertion.assertThat(membershipPage.getCtaBanner(), equalToIgnoringWhiteSpace(
                "Buying smart is just the start"), "Checking CTA banner contains proper text on membership page");

        browser.navigateBack();
        CustomHamcrestAssertion.assertThat(ratingsCompactPage.getCounterResult(), equalTo("75"),
                "Checking Number of models");

        ModelPage modelpage = ratingsCompactPage.clickShopButton();
        new CustomAssertion("Checking Price and Shop title appears")
                .assertTrue(modelpage.isPriceAndShopTitleDisplayed());

        AmazonPage amazonPage = modelpage.clickAmazonButton();
        CustomHamcrestAssertion.assertThat(amazonPage.getUrl(), containsString("amazon.com"),
                "Checking that amazon site is opened");
    }

    @Test(description = "Login feature")
    public void checkLoginOnBuyingGuide() {
        ModelPage modelPage = new ModelPage();
        OverviewPage overviewPage = modelPage.open()
                                             .clickUprightVacuumsLinkInBreadcrumbs();
        CustomHamcrestAssertion.assertThat(overviewPage.getHeroSectionText(), containsString(CTA_BANNER_OVERVIEW),
                "Checking text in CTA banner");

        BuyingGuidePage buyingGuidePage = overviewPage.clickBuyingGuideLink();
        String labelInHeroSection = buyingGuidePage.getLabelInHeroSectionText();

        CustomHamcrestAssertion.assertThat(labelInHeroSection, equalTo("Choosing the Best Vacuum Cleaner"),
                "Checking text in Hero section");

        loginServices.doLogin(user);
        new CustomAssertion("Checking lock disappearance")
                .assertFalse(buyingGuidePage.isLockNearRecommendedLinkDisplayed());
    }

    @Test(description = "Ratings feature")
    public void checkAddingModelsToComparision() throws InterruptedException {
        HomePage homePage = new HomePage().open();
        new CustomAssertion("Checking that Main Articles section appears")
                .assertTrue(homePage.isMainArticlesSectionDisplayed());

        loginServices.doLogin(user);
        new CustomAssertion("Comparing nickname with text in account info section")
                .assertEquals(homePage.getAccountInfoSectionText(), user.getNickname());

        searchServices.doSearch(MIELE_MODEL);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.waitTextToAppearInLabel("Showing results for Miele Dynamic U1 Cat");
        CustomHamcrestAssertion.assertThat(searchResultPage.getListOfBrands(), everyItem(startsWith("Miele")),
                "Checking that all models starts with Miele");

        ModelPage modelPage = searchResultPage.clickFirstResult();
        CustomHamcrestAssertion.assertThat(modelPage.getTitle(), equalTo(MIELE_MODEL),
                "Checking title of opened Model");

        RatingsCompactPage ratingsCompactPage = modelPage.clickIconInSwitcher(RatingsCompactPage.class, RatingsView.COMPACT);
        ratingsCompactPage.clickCloseTourButton();
        new CustomAssertion("Checking that Ratings List view is opened")
                .assertTrue(ratingsCompactPage.isRatingsListViewDisplayed());

        ratingsCompactPage.clickAddToCompareButton();
        CustomHamcrestAssertion.assertThat(ratingsCompactPage.getCompareCircleText(), equalTo("1"),
                "Checking that 1 model is added to Compare");

        RatingsFullPage ratingsFullPage = ratingsCompactPage.clickIconInSwitcher(RatingsFullPage.class, RatingsView.FULL);
        new CustomAssertion("Checking that Ratings Full view is opened")
                .assertTrue(ratingsFullPage.isRatingsFullViewDisplayed());

        ratingsFullPage.clickAddToCompareButton();
        CustomHamcrestAssertion.assertThat(ratingsFullPage.getCompareCircleText(), equalTo("2"),
                "Checking that 2 models are added to Compare");

        ComparePage comparePage = ratingsFullPage.clickCompareBucketButton()
                                                 .clickViewCompareButton();
        CustomHamcrestAssertion.assertThat(comparePage.getModelsList().get(1), equalTo("Shark Navigator Powered Lift-Away NV586 (Target)"),
                "Checking name of added model");
        CustomHamcrestAssertion.assertThat(comparePage.getModelsList().get(0), equalTo("Kenmore Elite Pet Friendly 31150"),
                "Checking name of added model");

        comparePage.clickRemoveButton("1");
        comparePage.clickRemoveButton("0");
        CustomHamcrestAssertion.assertThat(comparePage.getLabelFromEmptyPage(), equalTo("Your Compare Chart is Empty!"),
                "Empty Compare page appears");
    }

    @Test(description = "Filter feature")
    public void checkPriceFilter() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage();
        ratingsFullPage.open();
        loginServices.doLogin(user);
        ratingsFullPage.clickPriceFilterButton();
        String defaultPrice = ratingsFullPage.getPriceInputInFilterPopup();
        ratingsFullPage.movePriceSlider();
        new CustomAssertion("Comparing default price with price after moving slider")
                .assertNotEquals(ratingsFullPage.getPriceInputInFilterPopup(), defaultPrice);
    }

    @Test(description = "Ratings feature")
    public void checkRatingsSliderScroll() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage();
        ratingsFullPage.open();
        loginServices.doLogin(user);
        ratingsFullPage.moveRatingsSlider().highlightRatingsSlider();
        new CustomAssertion("Checking is Specs header is displayed in ratings chart")
                .assertTrue(ratingsFullPage.isSpecsHeaderDisplayedInRatingsChart());
    }

    @Test(description = "Ratings feature")
    public void checkRatingsJsScroll() {
        RatingsFullPage ratingsFullPage = new RatingsFullPage();
        ratingsFullPage.open();
        loginServices.doLogin(user);
        browser.scrollToBottomOfPage();
        HomePage homePage = ratingsFullPage.crLogoClick();
        new CustomAssertion("Comparing nickname with text in account info section")
                .assertEquals(homePage.getAccountInfoSectionText(), user.getNickname());
    }

    @Test(description = "Login feature")
    public void checkUserCanNotLoginWithInvalidPassword() {
        new HomePage().open();
        loginServices.doLogin(UserFactory.createUserInvalidPassword());
        new CustomAssertion("Comparing current url with expected")
                .assertEquals(driver.getCurrentUrl(), "https://secure.consumerreports.org/ec/login?error");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
       if(ITestResult.FAILURE==result.getStatus()){
            Screenshoter.takeScreenshot();
       }
        CrLogger.info("TEST FINISHES");
        WebDriverProviderSingleton.quitDriver();
    }
}