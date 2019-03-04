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

    Browser browser = new Browser();

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
        browser.navigateBack();
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
        browser.scrollToBottomOfPage();
        new RatingsFullPage().crLogoClick();
    }

    @Then("All models are (.*) brand and (.*)")
    public void allModelsAreProperBrand(String model, String result) {
        new SearchResultPage().waitTextToAppearInLabel(result);
        assertThat( new SearchResultPage().getListOfBrands(), Matchers.everyItem(startsWith(model)));
    }

    @And("Click first search result")
    public void clickFirstSearchResult() {
        new SearchResultPage().clickFirstResult();
    }

    @Then("Model (.*) is on (.*) position and Model (.*) is on (.*) position on Compare page")
    public void addedModelsAreOnComparePage(String firstModel,int firstPosition, String secondModel, int secondPosition) {
        assertThat(new ComparePage().getModelsList().get(firstPosition), equalTo(firstModel));
        assertThat(new ComparePage().getModelsList().get(secondPosition), equalTo(secondModel));

    }
}
