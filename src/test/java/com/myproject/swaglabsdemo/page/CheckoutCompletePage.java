package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Miroslav Kološnjaji
 */
public class CheckoutCompletePage extends BasePage {

    private static final String XPATH_TO_SUCCESS_MESSAGE = "//h2";
    private static final String TITLE = "Checkout: Complete!";

    protected CheckoutCompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSucessmessageDisplayed() {
        if (!webDriver.findElements(By.xpath(XPATH_TO_SUCCESS_MESSAGE)).isEmpty())
            return webDriver.findElement(By.xpath(XPATH_TO_SUCCESS_MESSAGE)).getText().equals("Thank You for your order!");

        return false;
    }

    @Override
    public boolean isCorrectPage() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE)).getText().equals(TITLE);
    }
}
