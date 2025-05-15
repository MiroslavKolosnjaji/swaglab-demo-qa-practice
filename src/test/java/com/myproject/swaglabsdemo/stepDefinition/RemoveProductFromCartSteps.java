package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * @author Miroslav Kološnjaji
 */
public class RemoveProductFromCartSteps extends BaseStep{


    @Inject
    protected RemoveProductFromCartSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @And("user remove desired products from the cart")
    public void userRemoveDesiredProductsFromTheCart() {

        List<String> productList = List.of("remove-sauce-labs-backpack",
                "remove-sauce-labs-bike-light");

       yourCartPage = productPage
               .removeProductsFromCart(productList)
               .checkShoppingCart();
    }

    @Then("verify that shopping cart contains notification with correct number {}")
    public void verifyThatShoppingCartContainsNotificationWithCorrectNumber(Integer quantity) {

        boolean isCorrect = productPage.verifyShoppingCartProductCount(quantity);
        assertTrue(isCorrect, "Displayed notification is incorrect.");
    }
}
