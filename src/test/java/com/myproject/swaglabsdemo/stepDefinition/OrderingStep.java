package com.myproject.swaglabsdemo.stepDefinition;

import com.google.inject.Inject;
import com.myproject.swaglabsdemo.entity.strategy.TestDataStrategy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

/**
 * @author Miroslav Kološnjaji
 */
public class OrderingStep extends BaseStep {

    private final TestDataStrategy testDataStrategy;

    @Inject
    public OrderingStep(WebDriver webDriver, TestDataStrategy testDataStrategy) {
        super(webDriver);

        this.testDataStrategy = testDataStrategy;
    }

    @Given("generate valid user")
    public void generateValidUser() {
        user = testDataStrategy.generateTestUserData();
    }


    @When("login as valid user")
    public void loginAsValidUserWithAnd() {
        productPage = loginPage
                .setUsername(user.getUserName())
                .setPassword(user.getPassword())
                .clickLogin();

        assertFalse(loginPage.isErrorMessageDisplayed(), "Login failed.");
    }

    @Then("verify that user landed on the products page")
    public void verifyThatUserLandedOnTheProductsPage() {

        boolean isCorrectPage = productPage.isCorrectPage();

        assertTrue(isCorrectPage, "User is not on the Products page.");

        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("window.alert=function(){};");
    }

    @And("user add desired products to the Cart")
    public void userAddDesiredProductsToTheCart() {

        List<String> productList = List.of(
                "add-to-cart-sauce-labs-backpack",
                "add-to-cart-sauce-labs-bike-light",
                "add-to-cart-sauce-labs-bolt-t-shirt",
                "add-to-cart-sauce-labs-fleece-jacket",
                "add-to-cart-sauce-labs-onesie",
                "add-to-cart-test.allthethings()-t-shirt-(red)");

        productPage
                .addProductsToCart(productList);

    }


    @Then("verify that shopping cart contains notification with correct number")
    public void verifyThatShoppingCartContainsNotificationWithCorrectNumber() {

        Integer quantity = 6;

        boolean isCorrect = productPage.verifyShoppingCartProductCount(quantity);
        assertTrue(isCorrect, "Displayed notification is incorrect.");
    }

    @And("checkout from the Cart")
    public void checkoutFromTheCart() {
        checkoutYourInformationPage = navigationService
                .navigateToShoppingCartPage(webDriver)
                .clickCheckout();

        assertTrue(checkoutYourInformationPage.isCorrectPage(), "User is not on the Cart page.");
    }

    @And("populate the form on the Your Information page")
    public void populateTheFormOnTheYourInformationPage() {
        checkoutOverviewPage = checkoutYourInformationPage
                .populateFirstNameField(user.getFirstName())
                .populateLastNameField(user.getLastName())
                .populatePostalCodeField(user.getPostalCode())
                .clickContinueButton();

        assertTrue(checkoutOverviewPage.isCorrectPage(), "User is not on the Checkout Overview page.");
    }


    @And("finish the order")
    public void finishTheOrder() {

        Map<String, String> summaryMap = checkoutOverviewPage.summaryInfo();

        assertEquals(summaryMap.get("subtotal"), "$129.94", "Item total price is not valid.");
        assertEquals(summaryMap.get("tax"), "$10.40", "Tax price is not valid.");
        assertEquals(summaryMap.get("total"), "$140.34", "Item total price is not valid.");


        checkoutCompletePage = checkoutOverviewPage
                .clickFinishButton();

        assertTrue(checkoutCompletePage.isCorrectPage(), "User is not on the Checkout Complete page.");
    }

    @Then("should receive the success message")
    public void shouldReceiveTheSuccessMessage() {

        boolean isCorrectMessage = checkoutCompletePage.isSuccessMessageDisplayed();
        assertTrue(isCorrectMessage, "Success message is not displayed");
    }


}
