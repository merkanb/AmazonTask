package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class YourListsPage extends BasePage {

    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//span[contains(text(),'Create a List')]/preceding-sibling::*")
    public WebElement createAListButton;

    @FindBy(css = "#list-name")
    public WebElement listNameInput;

    @FindBy(xpath = "//span[text()='Create List']/preceding-sibling::input")
    public WebElement createListButtonOnPopUp;

    @FindBy(xpath = "//img[@aria-label='More options']")
    public WebElement moreOptions;

    @FindBy(css = "#editYourList")
    public WebElement manageList;

    @FindBy(xpath = "//div[@id='list-settings-blackout-outer']/following-sibling::span/span")
    public WebElement deleteListButton;


//        @FindBy(xpath = "//span[@data-action='list-delete-confirm']")
//        @FindBy(id = "list-delete-confirm")
//        @FindBy(id = "list-delete-confirm-announce")
//        @FindBy(name = "submit.save")
//    @FindBy(xpath = "//span[@data-action='list-delete-confirm']/span/span")
//    @FindBy(xpath = "//span[@data-action='list-delete-confirm']/span/span/span")

//    @FindBy(xpath = "//input[@name='submit.save']/../../..")
//    @FindBy(xpath = "//input[@name='submit.save']/../..")
//    @FindBy(xpath = "//input[@name='submit.save']/..")
    @FindBy(xpath = "//input[@name='submit.save']")
//    @FindBy(xpath = "//input[@name='submit.save']/following-sibling::span")
    public WebElement deleteSubmitButton;


    public void createAList(String listName) {
        BrowserUtils.hover(helloUser);
        createAList.click();
        try {     // because if already created one list next createAListButton will not be there and throw NoSuchElementException
            createAListButton.click();
        } catch (NoSuchElementException nse) {
            System.out.println("Try Catch Exception Note: NoSuchElementException caught, there must be a list created already..");
        }
        listNameInput.clear();
        listNameInput.sendKeys(listName);
//        BrowserUtils.waitForClickability(createListButtonOnPopUp,10);
//        BrowserUtils.clickWithJS(createListButtonOnPopUp);
        BrowserUtils.waitFor(2);
        createListButtonOnPopUp.click();
        BrowserUtils.waitFor(2);
    }

    ProductPage productPage = new ProductPage();

    public void deleteTheList(String nameOfTheList) {
        BrowserUtils.hover(helloUser);
        YourLists.click();
        WebElement willDeleted = Driver.get().findElement(By.xpath("//span[contains(text(),'" + nameOfTheList + "')]"));
        willDeleted.click();
        moreOptions.click();
        manageList.click();
        BrowserUtils.hover(deleteListButton);
        deleteListButton.click();
//        deleteSubmitButton.click();
//        deleteSubmitButton.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(2);
        deleteSubmitButton.click();
//        BrowserUtils.clickWithJS(deleteSubmitButton);
        BrowserUtils.waitFor(2);
    }

    public void deleteTheListFromHomepage(String listName) {
        BrowserUtils.hover(helloUser);
        YourLists.click();
        Driver.get().findElement(By.xpath("//span[contains(text(),'" + listName + "')]")).click();
        moreOptions.click();
        manageList.click();
        BrowserUtils.hover(deleteListButton);
//        deleteListButton.click();
        BrowserUtils.clickWithJS(deleteListButton);
        deleteSubmitButton.click();
    }


}



