package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Miroslav Kološnjaji
 */
public class YourCartPage extends BasePage {

    private static final String TITLE = "Your Cart";

    @FindBy(xpath = "//button[@id = 'checkout']")
    @CacheLookup
    private WebElement btnCheckout;
    @FindBy(xpath = "//div[@class = 'cart_list']//div[@class = 'cart_item']")
    @CacheLookup
    private List<WebElement> elements;

    public YourCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutYourInformationPage clickCheckout() {
        WebDriverUtils.isVisible(btnCheckout);
        btnCheckout.click();
        return PageFactory.initElements(webDriver, CheckoutYourInformationPage.class);
    }

    public int cartItemQuantity(){
        return elements.size();
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }
}
