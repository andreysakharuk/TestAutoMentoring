package com.epam.cdp.reporting;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CrLogger {

    public static final Logger LOGGER = LogManager.getLogger(CrLogger.class);

    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }

    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void trace(String message) {
        LOGGER.trace(message);
    }

    public static void log(String message){
        LOGGER.info(message);
    }
}
