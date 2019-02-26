package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.pages.OverviewPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class OverviewSteps {

    @Then("Hero section appears on Overview page")
    public void heroSectionAppearsOnOverviewPage() {
        assertThat(new OverviewPage().getHeroSectionText(), containsString("Clear through the clutter when choosing the best vacuums."));
    }

    @And("Logged out user clicks Buying Guide link on Overview page")
    public void loggedOutUserClicksBuyingGuideLinkOnOverviewPage() {
        new OverviewPage().clickBuyingGuideLink();
    }

    @When("Logged out user clicks Upright link in Type section on Overview page")
    public void loggedOutUserClicksUprightLinkInTypeSectionOnOverviewPage() {
        new OverviewPage().open().clickUprightLinkInTypeSection();
    }
}
