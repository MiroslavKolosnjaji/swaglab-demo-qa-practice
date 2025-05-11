package com.myproject.swaglabsdemo.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

/**
 * @author Miroslav Kološnjaji
 */
public class PageLoaderHelper {

    public static void waitForPageToLoad(WebDriver webDriver,int timeoutInSeconds){
        new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds))
                .until(driver -> Objects.equals(((JavascriptExecutor) driver)
                        .executeScript("return document.readyState"), "complete"));
    }
}
