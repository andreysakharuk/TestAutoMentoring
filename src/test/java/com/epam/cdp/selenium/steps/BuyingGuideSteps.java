package com.epam.cdp.selenium.steps;

import com.epam.cdp.selenium.pages.BuyingGuidePage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BuyingGuideSteps {


    @Then("Label in Hero section appears on Buying Guide page")
    public void labelInHeroSectionAppearsOnBuyingGuidePage() {
        String labelInHeroSection = new BuyingGuidePage().getLabelInHeroSectionText();
        assertThat(labelInHeroSection, equalTo("Vacuum Buying Guide"));
        
    }

    @Then("Lock near Recommended link doesn't appear on Buying Guide page")
    public void lockNearRecommendedLinkDoesnTAppearOnBuyingGuidePage() {
        Assert.assertFalse(new BuyingGuidePage().isLockNearRecommendedLinkDisplayed());
    }

}
