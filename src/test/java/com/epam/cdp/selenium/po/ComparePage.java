package com.epam.cdp.selenium.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ComparePage extends AbstractPage {

    @FindBy(css = ".compare-page__model-name")
    private List<WebElement> listOfModels;

    @FindBy(css = ".shared-crux-icon.crux-icons.crux-icons-dontbuy")
    private WebElement removeCompareButton;

    @FindBy(css = ".crux-call-to-action")
    private WebElement emptyPageLabel;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListOfModels() {
        List<String> modelsList = new ArrayList<>();
        for (WebElement element : listOfModels) {
            modelsList.add(element.getText());
        }
        return modelsList;
    }

    public ComparePage clickOnRemoveButton() {
        removeCompareButton.click();
        return new ComparePage(driver);
    }

    public String getLabelFromEmptyPage() {
        return emptyPageLabel.getText();
    }
}
