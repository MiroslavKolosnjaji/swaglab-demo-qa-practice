package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Miroslav Kološnjaji
 */
public class CheckoutYourInformationPage extends BasePage {

    private final String TITLE = "Checkout: Your Information";


    @FindBy(how = How.ID, using = "first-name")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "last-name")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "postal-code")
    @CacheLookup
    private WebElement postalCodeField;

    @FindBy(how = How.ID, using = "postal-code")
    @CacheLookup
    private WebElement continueButton;

    public CheckoutYourInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutYourInformationPage populateFirstNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutYourInformationPage populateLastNameField(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutYourInformationPage populatePostalCodeField(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        continueButton.click();
        return PageFactory.initElements(webDriver, CheckoutOverviewPage.class);
    }


    @Override
    public boolean isCorrectPage() {
        return webDriver.findElement(By.xpath(XPATH_TO_PAGE_TITLE)).getText().equals(TITLE);
    }
}
