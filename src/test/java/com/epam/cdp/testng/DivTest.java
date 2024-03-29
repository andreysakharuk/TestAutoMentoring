package com.epam.cdp.testng;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivTest extends BaseTest {

    @Test
    @Parameters(value = {"a", "b"})
    public void sixDivideTwoLong(long a, long b) {
        long result = calc.div(a, b);
        Assert.assertEquals(result, 2);
    }

    @Test
    @Parameters({"a", "b"})
    public void sixDivideTwoDouble(double a, double b) {
        double result = calc.div(a, b);
        Assert.assertEquals(result, 2.0, 0.01);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void sixDivideZeroLong(){
            calc.div(6, 0);
    }

    @Test
    public void sixDivideZeroDouble() {
          double result = calc.div(6.0, 0.0);
          Assert.assertEquals(result,Double.POSITIVE_INFINITY);
    }
}