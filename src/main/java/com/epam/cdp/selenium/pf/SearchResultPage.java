package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(id = "search-top")
    private WebElement searchResultLabel;

    @FindBy(css = ".product-brand")
    private List<WebElement> modelsBrandList;

    protected SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfBrands() {
        waitForTextInElementToAppear(searchResultLabel, "Showing results for Miele Dynamic U1 Cat");
        return modelsBrandList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ModelPage clickFirstResult() {
        modelsBrandList.get(0).click();
        return new ModelPage(driver);
    }
}
