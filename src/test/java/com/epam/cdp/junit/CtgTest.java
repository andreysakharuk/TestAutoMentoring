package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;


public class CtgTest extends BaseTest {

    @Test
    public void ctqFromFortyFive() {
        double result = calc.ctg(45);
        Assert.assertEquals(1.0, result, 0.01);
    }
}