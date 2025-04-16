package com.myproject.swaglabsdemo.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Miroslav Kološnjaji
 */

public abstract class BasePage {

    protected static final String XPATH_TO_PAGE_TITLE = "span[@class='title']";
    protected final WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public abstract boolean isCorrectPage();
}
