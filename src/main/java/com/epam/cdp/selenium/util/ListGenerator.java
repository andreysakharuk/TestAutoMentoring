package com.epam.cdp.selenium.util;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ListGenerator {

    public List<String> getList(List<WebElement> modelsList){
        return modelsList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }
}
