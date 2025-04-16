package com.myproject.swaglabsdemo.page;

import lombok.Builder;
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

public class LoginPage extends BasePage {

    private static String XPATH_TO_ERROR_MESSAGE = "//h3[contains(text(), 'Epic sadface: ')]";
    private static final String TITLE = "Swag Labs";


    @FindBy(how = How.ID, using = "user-name")
    @CacheLookup
    private WebElement txtUsername;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@type='submit' and @id='login-button' and @value='Login']")
    @CacheLookup
    private WebElement btnLogin;

    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage setUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public ProductPage clickLogin() {
        btnLogin.click();
        return PageFactory.initElements(webDriver, ProductPage.class);
    }

    public boolean isErrorMessageDisplayed() {
        return !webDriver.findElements(By.xpath(XPATH_TO_ERROR_MESSAGE)).isEmpty();
    }

    @Override
    public boolean isCorrectPage() {
        return webDriver.getTitle().equals(TITLE);
    }


}
