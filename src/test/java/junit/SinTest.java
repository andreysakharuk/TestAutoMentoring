package junit;

import org.junit.Assert;
import org.junit.Test;

public class SinTest extends BaseTest {

    @Test
    public void sinFromDouble() {
        double result = calc.sin(45.0);
        Assert.assertEquals( 0.85, result, 0.01);
    }
}