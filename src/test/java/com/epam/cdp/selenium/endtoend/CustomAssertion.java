package com.epam.cdp.selenium.endtoend;

import com.epam.cdp.reporting.CrLogger;
import com.epam.cdp.selenium.util.Screenshoter;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

public class CustomAssertion extends Assertion {

    private String loggerInfo;

    public CustomAssertion(String loggerInfo) {
        this.loggerInfo = loggerInfo;
    }

    @Override
    public void onBeforeAssert(IAssert a) {
        CrLogger.info(loggerInfo);
    }

    @Override
    public void onAfterAssert(IAssert a) {
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        CrLogger.warn("ASSERTION PASSED!");
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        Screenshoter.takeScreenshot();
        CrLogger.error("ASSERTION FAILED!");
    }

}


