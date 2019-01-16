package com.epam.cdp.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

    @Test(groups = "sumTestLong")
    public void zeroPlusTwoLong() {
        long result = calc.sum(0, 2);
        Assert.assertEquals(result, 2);
    }

    @Test(groups = "sumTestLong")
    public void minusFivePlusTwoLong() {
        long result = calc.sum(-5, 2);
        Assert.assertEquals(result, -3);
    }

    @Test(dependsOnGroups = {"sumTestLong"})
    public void onePlusTwoDouble() {
        double result = calc.sum(1.2, 2.5);
        Assert.assertEquals(result, 3.7, 0.01);
    }

    @Test(groups = "sumTestDouble")
    public void minusThreePlusThreeDouble() {
        double result = calc.sum(-3.2, 3.2);
        Assert.assertEquals(result, 0.0, 0.01);
    }
}