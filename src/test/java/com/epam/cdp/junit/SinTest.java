package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class SinTest extends BaseTest {

    @Test
    public void sinFromFortyFive() {
        double result = calc.sin(3.14);
        Assert.assertEquals( 0.0, result, 0.01);
    }
}