package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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

    public ProductPage addProductsToCart(List<String> productList){
        productList.forEach(this::addProductToCart);
        return this;
    }

    public ProductPage addProductToCart(String xpath) {

        WebElement product = WebDriverUtils.isClicable(getProduct(xpath));
        product.click();
        WebDriverUtils.waitUntilVisible("//span[contains(@class, 'shopping_cart_badge')]");

        return this;
    }

    private WebElement getProduct(String xpath) {
        return webDriver.findElement(By.xpath(String.format(BASE_PRODUCT_ADD_BUTTON_PATH, xpath)));
    }

    private String productsQuantity() {
        WebDriverUtils.isVisible(shoppingCartLink);
        return shoppingCartLink.findElement(By.xpath(".//span")).getText();
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }

}
