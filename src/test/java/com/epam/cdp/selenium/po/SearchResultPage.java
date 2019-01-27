package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(id = "search-top")
    private WebElement searchResultLabel;

    @FindBy(css = ".product-brand")
    private List<WebElement> modelsBrand;

    protected SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfBrands() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElement(searchResultLabel,
                        "Showing results for Miele Dynamic U1 Cat"));
        List<String> lisOfbrands = new ArrayList<>();
        for (WebElement element : modelsBrand) {
            lisOfbrands.add(element.getText());
        }
        return lisOfbrands;
    }

    public ModelPage clickOnFirstResult() {
        modelsBrand.get(0).click();
        return new ModelPage(driver);
    }
}
