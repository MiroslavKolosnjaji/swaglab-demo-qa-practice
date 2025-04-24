package com.myproject.swaglabsdemo.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

/**
 * @author Miroslav Kološnjaji
 */
public class DriverProviderService {

    public static WebDriver getChromeDriver(){


        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getOptions());
    }


    public static WebDriver getWebDriver(BrowserType browserType){

        return switch (browserType){
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(getOptions());
            }
            case FIREFOX ->{
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
        };

    }

    private static ChromeOptions getOptions(){

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", Map.of("safebrowsing.enabled", false, "credentials_enable_service", false, "profile.password_manager_enabled", false));
        return options;
    }


    public enum BrowserType{
        CHROME,
        FIREFOX,
        EDGE;

        public static BrowserType fromString(String value){
            return BrowserType.valueOf(value.toUpperCase());
        }
    }

}
