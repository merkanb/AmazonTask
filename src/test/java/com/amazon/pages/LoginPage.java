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

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    public WebElement signInWindow;

    public void login() {
        BrowserUtils.hover(helloUser);
        System.out.println("helloUser.getText() = " + helloUser.getText());
        signInButton.click();
        emailInput.sendKeys(ConfigurationReader.get("email"));
        continueButton.click();
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        signInSubmit.click();
        Assert.assertTrue(!helloUser.getText().contains("sign in"));
    }

    public void signOut() {
        BrowserUtils.hover(helloUser);
        signOut.click();
        amazonHomePageAfterSignOut.click();
        Assert.assertTrue(signInWindow.getText().contains("sign in"));
    }

}
