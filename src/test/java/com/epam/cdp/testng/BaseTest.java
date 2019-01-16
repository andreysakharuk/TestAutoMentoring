package com.epam.cdp.testng;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected Calculator calc;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        calc = new Calculator();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        calc = null;
    }
}