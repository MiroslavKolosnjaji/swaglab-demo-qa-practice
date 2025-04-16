package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public class YourCartPage extends BasePage {

    private final String TITLE = "Your Cart";

    @FindBy(xpath = "//button[@id = 'checkout']")
    @CacheLookup
    private WebElement btnCheckout;

    protected YourCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutYourInformationPage clickCheckout() {
        btnCheckout.click();
        return PageFactory.initElements(webDriver, CheckoutYourInformationPage.class);
    }

    @Override
    public boolean isCorrectPage() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE)).getText().equals(TITLE);
    }
}
