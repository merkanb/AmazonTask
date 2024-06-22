package com.amazon.stepDefs;

import com.amazon.pages.YourListsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class YourListsStepDefs {

    YourListsPage yourListsPage = new YourListsPage();


    @Given("the user creates a list named as {string}")
    public void the_user_creates_a_list_named_as(String listName) {
        yourListsPage.createAList(listName);
    }


    @And("the user deletes the list {string}")
    public void theUserDeletesTheList(String nameOfTheList) {
        yourListsPage.deleteTheList(nameOfTheList);
    }


    @And("the user delete the list from Homepage {string}")
    public void theUserDeleteTheListFromHomepage(String listName) {
//        yourListsPage.deleteTheList(listName);
        yourListsPage.deleteTheListFromHomepage(listName);
    }


}

