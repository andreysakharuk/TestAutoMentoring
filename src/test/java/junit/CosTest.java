package junit;

import org.junit.Assert;
import org.junit.Test;

public class CosTest extends BaseTest {

    @Test
    public void cosFromDouble() {
        double result = calc.cos(45.0);
        Assert.assertEquals(0.52, result, 0.01);
    }
}