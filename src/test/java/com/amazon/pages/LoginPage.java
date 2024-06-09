package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#sp-cc-accept")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(css = "#ap_email")
    public WebElement emailInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    public WebElement signInSubmit;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(css = ".a-spacing-small")
    public WebElement signInWindow;


    HomePage homePage = new HomePage();

    public void login() {
        BrowserUtils.hover(helloUser);
        signInButton.click();
        emailInput.sendKeys(ConfigurationReader.get("email"));
        continueButton.click();
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        signInSubmit.click();
        Assert.assertTrue(!homePage.helloUser.getText().contains("sign in"));

    }

    public void signOut(){
        amazonHomePage.click();
        BrowserUtils.hover(helloUser);
        signOut.click();
        Assert.assertTrue(signInWindow.getText().contains("Sign in"));
    }

}
