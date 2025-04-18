package com.myproject.swaglabsdemo.util.config;

import com.myproject.swaglabsdemo.page.LoginPage;
import com.myproject.swaglabsdemo.page.YourCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public class NavigationService {

    private static final String XPATH_TO_SHOPPING_CART_LINK = "//div[@id='shopping_cart_container']//a";
    private static final String URL = "https://www.saucedemo.com/";


    public static LoginPage openLoginPage(WebDriver webDriver){
        webDriver.get(URL);
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    public YourCartPage navigateToShoppingCartPage(WebDriver webDriver){
        webDriver.findElement(By.xpath(XPATH_TO_SHOPPING_CART_LINK)).click();
        return PageFactory.initElements(webDriver, YourCartPage.class);
    }
}
