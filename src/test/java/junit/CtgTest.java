package junit;

import org.junit.Assert;
import org.junit.Test;


public class CtgTest extends BaseTest {

    @Test
    public void ctqFromDouble() {
        double result = calc.ctg(45.0);
        Assert.assertEquals(0.62, result, 0.01);
    }
}