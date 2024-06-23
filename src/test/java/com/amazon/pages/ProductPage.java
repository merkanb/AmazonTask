package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;


public class ProductPage extends BasePage{

    @FindBy(id="add-to-wishlist-button-submit")
    public WebElement addToListButton;

    @FindBy(css = "#wishListDropDown")
    public WebElement wishListDropDown;

    @FindBy(xpath = "//img[@alt='My Shopping List2']")
    public WebElement selectYourList;

    @FindBy(xpath = "//a[text()='View your List']")
    public WebElement viewYourList;

    @FindBy(css = "#continue-shopping")
    public WebElement continue_shopping;

}



