package com.myproject.swaglabsdemo.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * @author Miroslav Kološnjaji
 */
@Slf4j
public class ProductPage extends BasePage {

    private static final String BASE_PRODUCT_ADD_BUTTON_PATH = "//button[@id = '%s']";
    private static final String TITLE = "Products";

    @FindBy(xpath = "//div[@id = 'shopping_cart_container']//a")
    @CacheLookup
    private WebElement shoppingCartLink;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean verifyShoppingCartProductCount(Integer quantity) {

        log.info("The product quantity in the cart is {}", productsQuantity());

        return productsQuantity().equals(String.valueOf(quantity));
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }

    public ProductPage addProductsToCart(List<String> productList){
        productList.forEach(this::addProductToCart);
        return this;
    }

    public ProductPage addProductToCart(String xpath) {

        WebElement product =  webDriverWait.until(ExpectedConditions.elementToBeClickable(getProduct(xpath)));
        webDriverWait.until(ExpectedConditions.visibilityOf(product)).click();

        return this;
    }

    private WebElement getProduct(String xpath) {
        return webDriver.findElement(By.xpath(String.format(BASE_PRODUCT_ADD_BUTTON_PATH, xpath)));
    }

    private String productsQuantity() {
        return shoppingCartLink.findElement(By.xpath(".//span")).getText();
    }
}
