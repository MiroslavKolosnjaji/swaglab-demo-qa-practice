package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Miroslav Kološnjaji
 */
public class ProductPage extends BasePage {

    private static final String BASE_PRODUCT_ADD_BUTTON_PATH = "//button[@id = '%s']";
    private static final String TITLE = "Products";

    @FindBy(xpath = "//button[@id = 'add-to-cart-sauce-labs-backpack']")
    @CacheLookup
    private WebElement backPackAddButton;

    @FindBy(xpath = "//div[@id = 'shopping_cart_container']//a")
    @CacheLookup
    private WebElement shoppingCartLink;

    protected ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage addProductsToCart(List<String> products) {
        products.forEach(this::addProduct);
        return this;
    }

    public ProductPage addBackPackProductToCart() {
        addProduct("add-to-cart-sauce-labs-backpack");
        return this;
    }

    public ProductPage addBikeLightProductTOCart() {
        addProduct("add-to-cart-sauce-labs-bike-light");
        return this;
    }

    public ProductPage addBoltTShirtProductToCart() {
        addProduct("add-to-cart-sauce-labs-bolt-t-shirt");
        return this;
    }

    public ProductPage addFleeceJacketProductToCart() {
        addProduct("add-to-cart-sauce-labs-fleece-jacket");
        return this;
    }

    public ProductPage addOnesieProductToCart() {
        addProduct("add-to-cart-sauce-labs-onesie");
        return this;
    }

    public ProductPage addRedTShirtProductToCart() {
        addProduct("add-to-cart-test.allthethings()-t-shirt-(red)");
        return this;
    }

    public boolean verifyShoppingCartProductCount() {
        return shoppingCartLink.findElements(By.xpath(".//span")).size() == 6;
    }


    @Override
    public boolean isCorrectPage() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE)).getText().equals(TITLE);
    }

    private void addProduct(String xpath) {
        webDriver.findElement(By.xpath(String.format(BASE_PRODUCT_ADD_BUTTON_PATH, xpath))).click();
    }
}
