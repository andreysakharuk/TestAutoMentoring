package com.epam.cdp.selenium.steps;

import com.epam.cdp.bo.UserFactory;
import com.epam.cdp.selenium.Browser;
import com.epam.cdp.selenium.driver.WebDriverProviderSingleton;
import com.epam.cdp.selenium.pages.*;
import com.epam.cdp.selenium.services.LoginServices;
import com.epam.cdp.selenium.services.SearchServices;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CommonSteps {

    @And("User log in with valid credentials")
    public void doLogin(){
        new LoginServices().doLogin(UserFactory.getValidUser());
    }

    @And("User log in with invalid credentials")
    public void userLogInWithInvalidCredentials() {
        new LoginServices().doLogin(UserFactory.createUserInvalidPassword());
    }

    @Then("Error page is opened")
    public void errorPageIsOpened() {
        Assert.assertEquals(WebDriverProviderSingleton.getInstance().getCurrentUrl(), "https://secure.consumerreports.org/ec/login?error");
    }

    @Then("Cta banner appears on Membership page")
    public void ctaBannerAppearsOnMembershipPage() {
        assertThat(new MembershipPage().getCtaBanner(), equalToIgnoringWhiteSpace(
                "Buying smart is just the start"));
        new Browser().navigateBack();
    }

    @Then("Amazon site is opened")
    public void amazonSiteIsOpened() {
        assertThat(new AmazonPage().getUrl(), containsString("amazon.com"));
    }

    @And("Do Search for (.*)")
    public void doSearchFor(String arg0) {
        new SearchServices().doSearch(arg0);
    }

    @And("Click CR logo in footer")
    public void clickCRLogoInFooter() {
        new Browser().scrollToBottomOfPage();
        new RatingsFullPage().crLogoClick();
    }

    @Then("All models are Miele brand")
    public void allModelsAreMieleBrand() {
        new SearchResultPage().waitTextToAppearInLabel("Showing results for Miele Dynamic U1 Cat");
        assertThat( new SearchResultPage().getListOfBrands(), Matchers.everyItem(startsWith("Miele")));
    }

    @And("Click first search result")
    public void clickFirstSearchResult() {
        new SearchResultPage().clickFirstResult();
    }

    @Then("Added models are on Compare page")
    public void addedModelsAreOnComparePage() {
        assertThat(new ComparePage().getModelsList().get(1), equalTo("Shark Navigator Powered Lift-Away NV586 (Target)"));
        assertThat(new ComparePage().getModelsList().get(0), equalTo("Kenmore Elite Pet Friendly 31150"));
    }
}
