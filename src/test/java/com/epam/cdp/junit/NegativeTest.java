package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class NegativeTest extends BaseTest {

    @Test
    public void negativeMinusOneLong() throws IOException {
        boolean result = calc.isNegative(-1);
        Assert.assertTrue(result);
    }

    @Test
    public void negativeOneLong() {
        boolean result = calc.isNegative(1);
        Assert.assertFalse(result);
    }

    @Test
    public void negativeZeroLong() {
        boolean result = calc.isNegative(0);
        Assert.assertFalse(result);
    }
}