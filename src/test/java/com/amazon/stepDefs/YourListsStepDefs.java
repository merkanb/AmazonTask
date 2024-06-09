package com.amazon.stepDefs;

import com.amazon.pages.BasePage;
import com.amazon.pages.YourListsPage;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

public class YourListsStepDefs {

    YourListsPage yourListsPage = new YourListsPage();


    @Given("the user creates a list named as {string}")
    public void the_user_creates_a_list_named_as(String listName) {
        yourListsPage.createAList(listName);        // has o GOOD method
    }


    @And("the user deletes the list {string}")
    public void theUserDeletesTheList(String nameOfTheList) {
        yourListsPage.deleteTheList(nameOfTheList);
    }


    @And("the user delete the list from Homepage {string}")
    public void theUserDeleteTheListFromHomepage(String listName) {
        yourListsPage.deleteTheList(listName);
//        yourListsPage.deleteTheListFromHomepage(listName);
    }


}

