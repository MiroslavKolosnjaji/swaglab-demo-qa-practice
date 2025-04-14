package com.myproject.swaglabsdemo.stepDefinition;

import com.myproject.swaglabsdemo.driver.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
@Getter
public abstract class BaseStep {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();
}
