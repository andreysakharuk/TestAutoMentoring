package com.epam.cdp.assertion;

import com.epam.cdp.logging.CrLogger;
import com.epam.cdp.selenium.util.Screenshoter;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.StringDescription;

public class CustomHamcrestAssertion extends MatcherAssert {

    public static <T> void assertThat(T actual, Matcher<? super T> matcher, String loggerInfo) {
        assertThat("", actual, matcher, loggerInfo);
    }

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher, String loggerInfo) {
        CrLogger.info(loggerInfo);
        if (!matcher.matches(actual)) {
            CrLogger.error("ASSERTION FAILED!");
            Screenshoter.takeScreenshot();
            Description description = new StringDescription();
            description.appendText(reason)
                    .appendText("\nExpected: ")
                    .appendDescriptionOf(matcher)
                    .appendText("\n     but: ");
            matcher.describeMismatch(actual, description);

            throw new AssertionError(description.toString());
        }
        CrLogger.warn("ASSERTION PASSED!");
    }
}
