package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Miroslav Kološnjaji
 */
public class YourCartPage extends BasePage {

    private static final String TITLE = "Your Cart";

    @FindBy(xpath = "//button[@id = 'checkout']")
    @CacheLookup
    private WebElement btnCheckout;

    public YourCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutYourInformationPage clickCheckout() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btnCheckout));
        btnCheckout.click();
        return PageFactory.initElements(webDriver, CheckoutYourInformationPage.class);
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }
}
