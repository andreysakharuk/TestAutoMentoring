package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class CosTest extends BaseTest {

    @Test
    public void cosFromNinety() {
        double result = calc.cos(90);
        Assert.assertEquals(0.0, result, 0.01);
    }
}