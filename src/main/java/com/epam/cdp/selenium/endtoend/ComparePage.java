package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.logging.CrLogger;
import com.epam.cdp.selenium.wait.Waiter;
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

    @FindBy(css = ".compare-page__sub-header__models-number")
    private WebElement numberOfModels;

    public ComparePage() {
        super();
    }

    public List<String> getModelsList() {
        return modelsList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public ComparePage clickRemoveButton(String number) {
        CrLogger.info("Clicking Remove button");
        removeCompareButton.click();
        new Waiter().waitForTextInElementToAppear(numberOfModels, number);
        return new ComparePage();
    }

    public String getLabelFromEmptyPage() {
        return emptyPageLabel.getText();
    }
}
