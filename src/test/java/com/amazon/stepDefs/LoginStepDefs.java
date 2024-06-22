package com.amazon.stepDefs;

import com.amazon.pages.LoginPage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.acceptCookiesButton.click();
        Assert.assertEquals("Hello, sign in", loginPage.helloUser.getText());
//        Assert.assertTrue(loginPage.helloUser.getText().contains("sign in"));
    }


    @And("the user logs in successfully")
    public void theUserLogsInSuccessfully() {
        loginPage.login();
    }


    @And("the user logs out")
    public void theUserLogsOut() {
        loginPage.signOut();
    }

}

