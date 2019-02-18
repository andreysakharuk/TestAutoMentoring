package com.epam.cdp.selenium.util;

import java.util.Random;

public class RandomNumberUtils {

    public static final int DEFAULT_INTERVAL_INT = 99999;

    public static int getRandomInt(int maxValue) {
        return new Random().nextInt(maxValue);
    }

    public static int getRandomInt() {
        return getRandomInt(DEFAULT_INTERVAL_INT);
    }
}

