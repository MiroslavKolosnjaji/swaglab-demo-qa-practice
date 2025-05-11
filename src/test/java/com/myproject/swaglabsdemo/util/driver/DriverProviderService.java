package com.myproject.swaglabsdemo.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Kološnjaji
 */
public class DriverProviderService {

    public static WebDriver getWebDriver(BrowserType browserType) {

        return switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(getOptions());
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
        };

    }

    private static ChromeOptions getOptions() {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        return options;
    }


    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE;

        public static BrowserType fromString(String value) {
            return BrowserType.valueOf(value.toUpperCase());
        }
    }

}
