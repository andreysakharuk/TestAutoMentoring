package com.epam.cdp.selenium.driver;

import com.epam.cdp.base.ConfigProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverProviderSingleton {

    private static WebDriver driver;

    private WebDriverProviderSingleton() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            try {
                WebDriverProviderSingleton.initDriver();
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException");
            }
        }
        return driver;
    }

    public static WebDriver initDriver() throws MalformedURLException {
        ConfigProvider configProvider = new ConfigProvider();
        if (configProvider.isLocal()) {
            switch (configProvider.getBrowser()) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "libs/chromedriver_win32/chromedriver.exe");
                    driver = new ChromeDriver(new ChromeOptions());
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "libs/geckodriver_v024/geckodriver.exe");
                    driver = new FirefoxDriver(new FirefoxOptions());
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", "libs/IEDriverServer_3.9.0/IEDriverServer.exe");
                    driver = new InternetExplorerDriver(new InternetExplorerOptions());
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Wrong BROWSER parameter: %s.", configProvider.getBrowser()));
            }
        } else {
            MutableCapabilities capabilities;
            switch (configProvider.getBrowser()) {
                case CHROME:
                    capabilities = new ChromeOptions();
                    break;
                case FIREFOX:
                    capabilities = new FirefoxOptions();
                    break;
                case IE:
                    capabilities = new InternetExplorerOptions();
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Wrong BROWSER parameter: %s.", configProvider.getBrowser()));
            }
            driver = new RemoteWebDriver(new URL(configProvider.getHub()), capabilities);
        }
        driver.manage().timeouts().implicitlyWait(configProvider.getTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


}
