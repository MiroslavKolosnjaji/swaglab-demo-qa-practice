package com.myproject.swaglabsdemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Miroslav Kološnjaji
 */
public class LoginPage {

    @FindBy(how = How.ID, using = "user-name")
    @CacheLookup
    private WebElement txtUsername;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@type='submit' and @id='login-button' and @value='Login']")
    @CacheLookup
    private WebElement btnLogin;

    @FindBy(id = "react-burger-menu-btn")
    @CacheLookup
    WebElement burgerMenu;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void setUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickOnBurgerMenu() throws InterruptedException {
        burgerMenu.click();
        Thread.sleep(3000);
    }

    public void clickLogout(){
        lnkLogout.click();
    }
}
