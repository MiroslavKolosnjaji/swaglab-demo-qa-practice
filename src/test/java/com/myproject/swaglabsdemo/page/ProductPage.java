package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean verifyShoppingCartProductCount(Integer quantity) {

        log.info("The product quantity in the cart is {}, and quantity argument is {}", productsQuantity(), quantity);

        return productsQuantity().equals(String.valueOf(quantity));
    }

    public ProductPage addProductsToCart(List<String> productList) {
        productList.forEach(this::addProductToCart);
        return this;
    }

    public ProductPage addProductToCart(String xpath) {

        WebElement product = WebDriverUtils.isClicable(getProduct(xpath));
        product.click();
        WebDriverUtils.waitUntilVisible("//span[contains(@class, 'shopping_cart_badge')]");

        return this;
    }

    public ProductPage removeProductsFromCart(List<String> productList){
       return addProductsToCart(productList);
    }

    public ProductPage selectHamburgerMenu() {
        WebDriverUtils.isVisible(hamburgerMenu).click();

        return this;
    }

    public YourCartPage checkShoppingCart(){
        WebDriverUtils.isVisible(shoppingCartLink).click();

        return PageFactory.initElements(webDriver, YourCartPage.class);
    }

    public LoginPage logout(){

        WebElement logout = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        WebDriverUtils.waitUntilVisible(logout).click();

        return PageFactory.initElements(webDriver, LoginPage.class);
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
