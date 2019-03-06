package com.epam.cdp.selenium.steps;

import com.epam.cdp.bo.UserFactory;
import com.epam.cdp.selenium.endtoend.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    @When("Logged out User opens Home page")
    public void loggedOutUserOpensHomePage() {
        new HomePage().open();
    }

    @Then("Account Info section appears on Home page")
    public void accountInfoSectionAppearsOnHomePage() {
        Assert.assertEquals(new HomePage().getAccountInfoSectionText(), UserFactory.getValidUser().getNickname());
    }

    @Then("Main Articles section appears on Home page")
    public void mainArticlesSectionAppearsOnHomePage() {
        Assert.assertTrue(new HomePage().isMainArticlesSectionDisplayed());
    }
}
