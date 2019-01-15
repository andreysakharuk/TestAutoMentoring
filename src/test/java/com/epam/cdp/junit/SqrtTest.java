package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class SqrtTest extends BaseTest {

    @Test(expected = Exception.class)
    public void extractSquareFromMinusNineDouble() {
        double result = calc.sqrt(-9.0);
        Assert.assertEquals(3.0, result, 0.01);
    }

    @Test
    public void extractSquareFromNineDouble() {
        double result = calc.sqrt(9.0);
        Assert.assertEquals(3.0, result, 0.01);
    }
}