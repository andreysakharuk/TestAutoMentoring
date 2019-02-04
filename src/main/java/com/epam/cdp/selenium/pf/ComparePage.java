package com.epam.cdp.selenium.pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ComparePage extends BasePage {

    @FindBy(css = ".compare-page__model-name")
    private List<WebElement> modelsList;

    @FindBy(css = ".shared-crux-icon.crux-icons.crux-icons-dontbuy")
    private WebElement removeCompareButton;

    @FindBy(css = ".crux-call-to-action")
    private WebElement emptyPageLabel;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getModelsList() {
        List<String> modelsListFull = modelsList.stream().map(WebElement::getText).collect(Collectors.toList());
        return modelsListFull;
    }

    public ComparePage clickRemoveButton() {
        removeCompareButton.click();
        return new ComparePage(driver);
    }

    public String getLabelFromEmptyPage() {
        return emptyPageLabel.getText();
    }
}
