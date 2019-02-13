package com.epam.cdp.selenium.pf;

import com.epam.cdp.selenium.util.ListGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(id = "search-top")
    private WebElement searchResultLabel;

    @FindBy(css = ".product-brand")
    private List<WebElement> modelsBrandList;

    protected SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void waitTextToAppearInLabel(String text){
        waitForTextInElementToAppear(searchResultLabel, text);
    }

    public List<String> getListOfBrands() {
        return new ListGenerator().getList(modelsBrandList);
    }

    public ModelPage clickFirstResult() {
        modelsBrandList.get(0).click();
        return new ModelPage(driver);
    }
}
