package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class YourListsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Create a List')]/preceding-sibling::*")
    public WebElement createAListButton;

    @FindBy(css = "#list-name")
    public WebElement listNameInput;

    @FindBy(xpath = "//span[text()='Create']/preceding-sibling::input")
    public WebElement createListButtonOnPopUp;

    @FindBy(xpath = "//img[@aria-label='More options']")
    public WebElement moreOptions;

    @FindBy(css = "#editYourList")
    public WebElement manageList;

    @FindBy(xpath = "//div[@id='list-settings-blackout-outer']/following-sibling::span/span")
    public WebElement deleteListButton;

    @FindBy(xpath = "//input[@name='submit.save']")
    public WebElement deleteSubmitButton;


    public void createAList(String listName) {
        BrowserUtils.hover(helloUser);
        createAList.click();
        try {
            createAListButton.click();
        } catch (NoSuchElementException nse) {
            System.out.println("Try Catch Exception Note: NoSuchElementException caught, there must be a list created already..");
        }
        listNameInput.clear();
        listNameInput.sendKeys(listName);
        BrowserUtils.waitFor(2);
        createListButtonOnPopUp.click();
        BrowserUtils.waitFor(2);
    }


    public void deleteTheList(String listName) {
        BrowserUtils.hover(helloUser);
        YourLists.click();
        BrowserUtils.waitForClickablility(By.xpath("//span[contains(text(),'" + listName + "')]"), 2);
        Driver.get().findElement(By.xpath("//span[contains(text(),'" + listName + "')]")).click();
        moreOptions.click();
        manageList.click();
        BrowserUtils.hover(deleteListButton);
//        deleteListButton.click();
        BrowserUtils.clickWithJS(deleteListButton);
        BrowserUtils.waitFor(2);
        deleteSubmitButton.click();
        BrowserUtils.waitFor(2);
    }

}



