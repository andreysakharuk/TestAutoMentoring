package com.epam.cdp.base;

import com.epam.cdp.selenium.driver.WebDriverTypes;

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

    public WebDriverTypes getBrowser(){
        return WebDriverTypes.valueOf(properties.getProperty("browser"));
    }

    public boolean isLocal(){
        return Boolean.parseBoolean(properties.getProperty("local"));
    }

    public int getTimeout(){
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getHub(){
        return properties.getProperty("hub");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getInvalidUsername() {
        return properties.getProperty("invalid_username");
    }

    public String getInvalidPassword() {
        return properties.getProperty("invalid_password");
    }

    public String getNickname() {
        return properties.getProperty("nickname");
    }


}
