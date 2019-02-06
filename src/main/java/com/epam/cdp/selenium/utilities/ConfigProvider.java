package com.epam.cdp.selenium.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {

    private String browser;
    private boolean local;

    public ConfigProvider() {
        this.browser = null;
        this.local = false;
    }

    public String getBrowser() {
        return browser;
    }

    public Boolean getLocal() {
        return local;
    }

    public void retrieveValues() {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("C:\\tam\\cdp\\src\\test\\resources\\Configuration.properties");
            prop.load(input);

            this.browser = prop.getProperty("browser");
            this.local = Boolean.parseBoolean(prop.getProperty("local"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
