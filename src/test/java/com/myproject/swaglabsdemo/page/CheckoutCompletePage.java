package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class CheckoutCompletePage extends BasePage {

    private static final String XPATH_TO_SUCCESS_MESSAGE = ".//h2[@class = 'complete-header']";
    private static final String TITLE = "Checkout: Complete!";

    public CheckoutCompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSuccessMessageDisplayed() {

        WebElement messageElement = webDriver.findElement(By.xpath(XPATH_TO_SUCCESS_MESSAGE));

        WebDriverUtils.isVisible(messageElement);

        log.info("CHECKOUT COMPLETE MESSAGE: {}", messageElement.getText());

        return messageElement.getText().equals("Thank you for your order!");
    }

    public boolean isCorrectPage() {
      return isCorrectPage(TITLE);
    }
}
