package com.epam.cdp.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends BaseTest {

    @DataProvider(name = "dataLong")
    public static Object[][] providerLong() {
        return new Object[][]{
                {2L, 3L, 6L},
                {4L, 3L, 12L},
                {0L, 5L, 0L},
        };
    }

    @Test(dataProvider = "dataLong")
    public void twoMultiplyTreeLong(long a, long b, long expectedResult) {
        long actualResult = calc.mult(a, b);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataDouble")
    public static Object[][] providerDouble() {
        return new Object[][]{
                {2.5, 3.0, 7.5},
                {4.5, 3.5, 15.75},
                {0.0, 5.0, 0.0},
        };
    }

    @Test(dataProvider = "dataDouble")
    public void twoMultiplyTreeDouble(double a, double b, double expectedResult) {
        double result = calc.mult(a, b);
        Assert.assertEquals(result, expectedResult, 0.01);
    }

}