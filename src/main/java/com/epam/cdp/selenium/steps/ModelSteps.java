package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.pages.ModelPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModelSteps {

    @When("Logged out user clicks Upright link in Breadcrumbs on Model page")
    public void loggedOutUserClicksUprightLinkInBreadcrumbs() {
       new ModelPage().open().clickUprightVacuumsLinkInBreadcrumbs();
    }

    @Then("Price And Shop title appears on Model page")
    public void priceAndShopTitleAppearsOnModelPage() {
        Assert.assertTrue(new ModelPage().isPriceAndShopTitleDisplayed());
    }

    @And("User click Amazon button on Model page")
    public void userClickAmazonButtonOnModelPage() {
        new ModelPage().clickAmazonButton();
    }

    @Then("Title (.*) appears on Model page")
    public void titleAppearsOnModelPage(String model) {
        assertThat(new ModelPage().getTitle(), equalTo(model));
    }
}
