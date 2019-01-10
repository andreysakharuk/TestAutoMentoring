package com.epam.cdp.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends BaseTest {

    @Test(groups = {"subTestLong"})
    public void threeMinusOneLong(){
        long result = calc.sub(3, 1);
        Assert.assertEquals(result, 2);
    }

    @Test(groups = {"subTestLong"})
    public void MinusSevenMinusSevenLong(){
        long result = calc.sub(-7, 7);
        Assert.assertEquals(result, -14);
    }

    @Test
    public void minusThreeMinusOneDouble(){
        double result = calc.sub(-3.0, 1.0);
        Assert.assertEquals(result, -4.0,0.01);
    }

    @Test(groups = "subTestDouble")
    public void SevenMinusSevenDouble(){
        double result = calc.sub(7.0, 7.0);
        Assert.assertEquals(result, 0.0,0.01);
    }
}