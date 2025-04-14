package com.myproject.swaglabsdemo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Miroslav Kološnjaji
 */
@Getter
public class DriverManager {

    private static final DriverManager INSTANCE = new DriverManager();

    private WebDriver webDriver;

    private DriverManager() {
    }

    public static DriverManager getInstance(){
        return INSTANCE;
    }

    public void setDriver(Driver driver){
        webDriver = switch (driver) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case INTERNET_EXPLORER -> {
                WebDriverManager.edgedriver().setup();
                yield new InternetExplorerDriver();
            }
        };
    }

    public enum Driver {
        CHROME,
        FIREFOX,
        INTERNET_EXPLORER
    }
}
