package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class PositiveTest extends BaseTest {

    @Test
    public void positiveOneLong() {
        boolean result = calc.isPositive(1);
        Assert.assertTrue(result);
    }

    @Test
    public void positiveMinusOneLong() {
        boolean result = calc.isPositive(-1);
        Assert.assertFalse(result);
    }

    @Test
    public void positiveZeroLong() {
        boolean result = calc.isPositive(0);
        Assert.assertFalse(result);
    }
}