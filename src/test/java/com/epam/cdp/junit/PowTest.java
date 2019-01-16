package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class PowTest extends BaseTest {

    @Test
    public void twoMultiplyFiveTimesDouble() {
        double result = calc.pow(2.3, 5.0);
        Assert.assertEquals(64.36, result, 0.01);
    }
}