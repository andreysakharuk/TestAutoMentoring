package com.epam.cdp.selenium.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {

    private static final String TEST_PROPERTIES_FILE = "test.properties";
    private Properties properties = new Properties();


    public ConfigProvider() {
        loadProperties();
    }

    private void loadProperties(){
        try {
            try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(TEST_PROPERTIES_FILE)){
                properties.load(inputStream);
        }
    } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public boolean isLocal(){
        return Boolean.parseBoolean(properties.getProperty("local"));
    }

    public int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
    }

}
