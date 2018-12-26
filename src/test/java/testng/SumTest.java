package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

    @Test(groups = "sumTest")
    public void zeroPlusTwoLong() {
        long result = calc.sum(0, 2);
        Assert.assertEquals( result, 2);
    }

    @Test(dependsOnGroups = "sumTest")
    public void onePlusTwoDouble() {
        double result = calc.sum(1.2, 2.5);
        Assert.assertEquals(result, 3.8, 0.1);
    }
}