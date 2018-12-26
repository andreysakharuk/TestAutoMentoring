package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends BaseTest {

    @Test(groups = {"subTest"})
    public void threeMinusOneLong(){
        long result = calc.sub(3, 1);
        Assert.assertEquals(result, 2);
    }

    @Test(groups = "subTest")
    public void minusThreeMinusOneDouble(){
        double result = calc.sub(-3, 1);
        Assert.assertEquals(result, -4.0,0.01);
    }
}