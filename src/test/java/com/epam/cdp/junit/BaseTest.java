package com.epam.cdp.junit;

import com.epam.tat.module4.Calculator;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null;
    }
}