package com.myproject.swaglabsdemo.util;

import com.codeborne.selenide.impl.WebElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Miroslav Kološnjaji
 */
public class WebDriverUtils {

    private static WebDriverWait webDriverWait;

    public static void createInstance(WebDriver webDriver, Duration duration) {
        webDriverWait = new WebDriverWait(webDriver, duration);
    }

    public static WebElement isClicable(String xpath) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static WebElement isClicable(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement isVisible(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean isDisplayed(WebElement webElement){
        return webDriverWait.until(webDriver -> webElement.isDisplayed());
    }

    public static WebElement waitUntilVisible(String xPath){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public static WebElement waitUntilVisible(WebElement element){
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }


}
