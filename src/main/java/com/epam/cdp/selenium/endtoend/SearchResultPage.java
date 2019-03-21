package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.reporting.CrLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    @FindBy(id = "search-top")
    private WebElement searchResultLabel;

    @FindBy(css = ".product-brand")
    private List<WebElement> modelsBrandList;

    public SearchResultPage() {
        super();
    }

    public void waitTextToAppearInLabel(String text){
        waiter.waitForTextInElementToAppear(searchResultLabel, text);
    }

    public List<String> getListOfBrands() {
        return modelsBrandList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public ModelPage clickFirstResult() {
        CrLogger.info("Clicking First result link");
        modelsBrandList.get(0).click();
        return new ModelPage();
    }
}
