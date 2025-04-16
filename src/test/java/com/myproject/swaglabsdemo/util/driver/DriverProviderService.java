package com.myproject.swaglabsdemo.util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Miroslav Kološnjaji
 */
public class DriverProviderService {

    public static WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver getFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
