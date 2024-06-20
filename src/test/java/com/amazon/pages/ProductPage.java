package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.html.CSS;


public class ProductPage extends BasePage{

    @FindBy(id="add-to-wishlist-button-submit")
//    @FindBy(css = ".a-button-text.a-text-left")
    public WebElement addToListButton;

    @FindBy(css = "#wishListDropDown")
    public WebElement wishListDropDown;

    @FindBy(xpath = "//img[@alt='My Shopping List2']")
    public WebElement selectYourList;

    @FindBy(xpath = "//a[text()='View your List']")
    public WebElement viewYourList;       // after product added to list, there is page opens, in it we can see this viewYourList WE

    @FindBy(css = "#continue-shopping")
    public WebElement continue_shopping;



}



