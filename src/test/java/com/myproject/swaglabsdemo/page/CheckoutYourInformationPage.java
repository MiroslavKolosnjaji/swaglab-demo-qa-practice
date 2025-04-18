package com.myproject.swaglabsdemo.page;

import com.myproject.swaglabsdemo.util.WebDriverUtils;
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

    private static final String TITLE = "Checkout: Your Information";


    @FindBy(how = How.ID, using = "first-name")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "last-name")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "postal-code")
    @CacheLookup
    private WebElement postalCodeField;

    @FindBy(how = How.ID, using = "continue")
    @CacheLookup
    private WebElement continueButton;

    public CheckoutYourInformationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutYourInformationPage populateFirstNameField(String firstName) {
        WebDriverUtils.isClicable(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutYourInformationPage populateLastNameField(String lastName) {
        WebDriverUtils.isClicable(lastNameField);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutYourInformationPage populatePostalCodeField(String postalCode) {
        WebDriverUtils.isClicable(postalCodeField);
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        WebDriverUtils.isVisible(continueButton);
        continueButton.click();
        return PageFactory.initElements(webDriver, CheckoutOverviewPage.class);
    }

    public boolean isCorrectPage() {
        return isCorrectPage(TITLE);
    }
}
