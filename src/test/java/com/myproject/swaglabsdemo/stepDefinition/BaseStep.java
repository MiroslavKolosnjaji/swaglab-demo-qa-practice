package com.myproject.swaglabsdemo.stepDefinition;

import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
public abstract class BaseStep {

    protected final WebDriver webDriver;

    protected BaseStep(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
