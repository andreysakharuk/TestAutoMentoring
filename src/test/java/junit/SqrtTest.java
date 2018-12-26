package junit;

import org.junit.Assert;
import org.junit.Test;

public class SqrtTest extends BaseTest {

    @Test
    public void extractSquareFromNineDouble() {
        double result = calc.sqrt(9.0);
        Assert.assertEquals(3.0, result, 0.01);
    }
}