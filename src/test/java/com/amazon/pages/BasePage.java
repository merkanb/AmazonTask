package com.amazon.pages;


import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {                // it is an abstract class !!

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


//    @FindBy(css = "#nav-link-accountList-nav-line-1")
//    @FindBy(css = "#nav-link-accountList")
//    @FindBy(css = ".nav-a.nav-a-2.nav-truncate.nav-progressive-attribute")
    @FindBy(css = "#nav-link-accountList")
    public WebElement helloUser;

    @FindBy(xpath = "//span[text()='Your Lists']")
    public WebElement YourLists;

    @FindBy(xpath = "//span[text()='Create a List']")
    public WebElement createAList;

    @FindBy(css = ".a-icon.a-icon-logo")
    public WebElement amazonHomePageAfterSignOut;

}
