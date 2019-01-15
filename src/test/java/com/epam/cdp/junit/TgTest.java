package com.epam.cdp.junit;

import org.junit.Assert;
import org.junit.Test;

public class TgTest extends BaseTest {

    @Test
    public void onePlusTwoLong() {
        double result1 = calc.tg(3.14);
        Assert.assertEquals(0.0, result1, 0.01);
    }
}