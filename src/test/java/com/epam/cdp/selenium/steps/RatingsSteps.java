package com.epam.cdp.selenium.steps;

import com.epam.cdp.bo.RatingsView;
import com.epam.cdp.selenium.endtoend.ComparePage;
import com.epam.cdp.selenium.endtoend.ModelPage;
import com.epam.cdp.selenium.endtoend.RatingsCompactPage;
import com.epam.cdp.selenium.endtoend.RatingsFullPage;
import com.epam.cdp.selenium.services.FilterServices;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Every.everyItem;

public class RatingsSteps {

    @Given("Logged out user opens Ratings page")
    public void openRatingsFullPage() {
        new RatingsFullPage().open();
    }

    @And("User clicks Recommended Toggle")
    public void userClicksRecommendedToggle() {
        new RatingsFullPage().clickRecommendedToggle();
    }

    @Then("CTA banner isn't displayed on Ratings Full page")
    public void ctaBannerIsnTDisplayed() {
        Assert.assertFalse(new RatingsFullPage().isCtaBannerDisplayed());
    }


    @Then("Recommended models are displayed in Ratings chart")
    public void recommendedModelsAreDisplayedInRatingsChart() {
        new RatingsFullPage().getLabelsListFromRatingsChart().forEach(label -> {
            assertThat(label, either(containsString("RECOMMENDED")).or(containsString("BEST BUY")));
        });
    }

    @And("User clicks Clear All button")
    public void userClicksClearAllButton() {
        new RatingsFullPage().clickClearAllLink();
    }

    @Then("All (.*) models are displayed in Ratings chart")
    public void allModelsAreDisplayedInRatingsChart(String result) {
        Assert.assertEquals(new RatingsFullPage().getResultCounter(), result);
    }



    @Then("Model's prices are less than (.*)")
    public void modelSPricesAreLessThanInRatingsChartPrice(int price) {
        assertThat(new RatingsFullPage().getPricesListFromRatingsChart(), everyItem(lessThanOrEqualTo(price)));
    }

    @And("Do Rated Best Filtering with (.*)")
    public void doRatedBestFiltering(int attribute) {
        new FilterServices().doRatedBestFiltering(attribute);
    }


    @Then("Rated Best button becomes green")
    public void ratedBestButtonBecomesGreen() {
        assertThat(new RatingsFullPage().getColorOfRatedBestFilterButton(), containsString("0, 174, 77"));
    }

    @And("Do More Filtering with (.*)")
    public void doMoreFiltering(String brand) {
        new FilterServices().doMoreFiltering(brand);
    }


    @Then("All models are proper (.*) in Ratings chart")
    public void allModelsAreProperBrandInRatingsChart(String brand) {
        assertThat(new RatingsFullPage().getBrandsAndModelsListInRatingsChart(), Matchers.everyItem(containsString(brand)));
    }

    @And("User clicks Price Filter button")
    public void userClicksPriceFilterButton() {
        new RatingsFullPage().clickPriceFilterButton();
    }


    @Then("Default price is changed after moving slider")
    public void defaultPriceIsChangedAfterMovingSlider() {
        String defaultPrice = new RatingsFullPage().getPriceInputInFilterPopup();
        new RatingsFullPage().movePriceSlider();
        Assert.assertNotEquals(new RatingsFullPage().getPriceInputInFilterPopup(), defaultPrice);
    }

    @And("Do Price Filtering with (.*)")
    public void doPriceFilteringWithPrice(String price) {
        new FilterServices().doPriceFiltering(price);
    }

    @Then("Cta banner appears on Ratings Compact page")
    public void ctaBannerAppearsOnRatingsCompactPage() {
        assertThat(new RatingsCompactPage().getCtaBannerText(), equalTo("Get Ratings & Reviews for the Products You Want"));
    }

    @And("Logged out user clicks Become a Member link")
    public void loggedOutUserClicksBecomeAMemberLink() {
        new RatingsCompactPage().clickBecomeMemberLink();
    }

    @And("User clicks Shop button on Ratings Compact page")
    public void userClicksShopButtonOnRatingsCompactPage() {
        new RatingsCompactPage().open().clickShopButton();
    }

    @And("Move slider in Ratings chart")
    public void moveSliderInRatingsChart() {
        new RatingsFullPage().moveRatingsSlider().highlightRatingsSlider();
    }

    @Then("Specs header appears")
    public void specsHeaderAppears() {
        Assert.assertTrue(new RatingsFullPage().isSpecsHeaderDisplayedInRatingsChart());
    }

    @And("Click Ratings Compact icon")
    public void clickRatingsCompactIcon() {
        RatingsCompactPage ratingsCompactPage = new ModelPage().clickIconInSwitcher(RatingsCompactPage.class, RatingsView.COMPACT);
        ratingsCompactPage.clickCloseTourButton();
    }

    @Then("Ratings list is displayed")
    public void ratingsListIsDisplayed() {
        Assert.assertTrue(new RatingsCompactPage().isRatingsListViewDisplayed());
    }

    @And("Click Add to Compare button")
    public void clickAddToCompareButton() {
        new RatingsCompactPage().clickAddToCompareButton();
    }

    @Then("(.*) Model is added to Compare bucket on Ratings Compact page")
    public void modelIsAddedToCompareBucket(String modelName) {
        assertThat(new RatingsCompactPage().getCompareCircleNumber(), equalTo(modelName));
    }

    @And("Click Ratings Full icon")
    public void clickRatingsFullIcon() {
        new RatingsCompactPage().clickIconInSwitcher(RatingsFullPage.class, RatingsView.FULL);
    }

    @Then("Ratings full view is displayed")
    public void ratingsFullViewIsDisplayed() {
        Assert.assertTrue(new RatingsFullPage().isRatingsFullViewDisplayed());
    }

    @Then("(.*) Model is added to Compare bucket on Ratings Full page")
    public void modelIsAddedToCompareBucketOnRatingsFullPage(String modelName) {
        assertThat(new RatingsFullPage().getCompareCircleNumber(), equalTo(modelName));
    }

    @And("Click View button in Compare bucket")
    public void clickViewButtonInCompareBucket() {
        new RatingsFullPage().clickCompareBucketButton()
                .clickViewCompareButton();
    }

    @And("Click Remove buttons")
    public void clickRemoveButtons() {
        new ComparePage().clickRemoveButton()
                .clickRemoveButton();
    }

    @Then("Error appears on Empty Compare page")
    public void errorAppearsOnEmptyComparePage() {
        assertThat(new ComparePage().getLabelFromEmptyPage(), equalTo("Your Compare Chart is Empty!"));
    }

    @And("Click Add to Compare button on Ratings Full page")
    public void clickAddToCompareButtonOnRatingsFullPage() {
        new RatingsFullPage().clickAddToCompareButton();
    }
}
