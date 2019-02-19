package com.epam.cdp.selenide;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    public void loggedOutUserCanSearch() {
        open("https://www.consumerreports.org/cro/index.htm");
        $(".gnav-typeahead-input").setValue("Miele Dynamic U1 Cat & Dog").pressEnter();
        $(".heading-title crux-section-header").should(Condition.disappear);
        $("#search-top").shouldHave(Condition.text("Showing results for Miele Dynamic U1 Cat"));
        $$(".news-item").shouldHave(size(4));
    }
}
