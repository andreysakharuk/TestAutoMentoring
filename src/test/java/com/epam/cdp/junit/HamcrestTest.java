package com.epam.cdp.junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestTest extends BaseTest {

    @Test
    public void twentyPlusFortyThreeLong() {
        long result = calc.sum(20, 43);
        assertThat(result, is(equalTo(63L)));
    }

    @Test
    public void arrayChecking() {
        Long[] mass = new Long[]{calc.sum(20L, 43L), calc.sum(-28, 78)};
        assertThat(mass, arrayContaining(63L, 50L));
    }

    @Test
    public void collectionChecking() {
        List<Long> list = Arrays.asList(calc.sum(20L, 43L), calc.sum(-28, 78));
        assertThat(list, contains(63L, 50L));
    }

    @Test
    public void positiveOneLong() {
        Map<String, Long> map = new HashMap<>();
        map.put("Result of multiplying 2 and 3 ", calc.mult(2L, 3L));
        assertThat(map, hasValue(6L));
    }


}
