package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;


public class ProductPage extends BasePage {

    @FindBy(id="add-to-wishlist-button-submit")
    public WebElement addToListButton;

    @FindBy(css = "#wishListDropDown")
    public WebElement wishListDropDown;

    @FindBy(xpath = "//a[text()='View your List']")
    public WebElement viewYourList;

    @FindBy(css = "#continue-shopping>span>span>input")
    public WebElement continue_shopping;

    public void selectAndAddListFromAddToListDropDown(String listName) {
        wishListDropDown.click();
        WebElement selectedList = Driver.get().findElement(By.xpath("//img[@alt='" + listName + "']"));
        selectedList.click();
        continue_shopping.click();
        BrowserUtils.waitFor(2);
    }

}



