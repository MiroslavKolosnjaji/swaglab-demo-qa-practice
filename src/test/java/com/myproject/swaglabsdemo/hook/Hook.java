package com.myproject.swaglabsdemo.hook;

import com.myproject.swaglabsdemo.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
public class Hook {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        DriverManager driverManager = DriverManager.getInstance();
        driverManager.setDriver(DriverManager.Driver.CHROME);

        webDriver = driverManager.getWebDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if(webDriver != null)
            webDriver.quit();
    }
}
