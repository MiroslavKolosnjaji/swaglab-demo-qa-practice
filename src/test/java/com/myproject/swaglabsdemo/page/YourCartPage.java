package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        WebDriverUtils.isVisible(btnCheckout);
        btnCheckout.click();
        return PageFactory.initElements(webDriver, CheckoutYourInformationPage.class);
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }
}
