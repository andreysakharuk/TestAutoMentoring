package junit;

import org.junit.Assert;
import org.junit.Test;

public class TgTest extends BaseTest {

    @Test
    public void onePlusTwoLong() {
        double result1 = calc.tg(45.0);
        Assert.assertEquals(1.61, result1, 0.01);
    }
}