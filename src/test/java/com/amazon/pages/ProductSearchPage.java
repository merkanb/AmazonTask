package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductSearchPage extends BasePage {

    @FindBy(css = "#searchDropdownBox")
    public WebElement categoryDropdown;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchIcon;

    @FindBy(css = ".a-color-state.a-text-bold")
    public WebElement searchResultMessage;


// 1st way  - it is not working, have to work on it
//        @FindBys({
//            @FindBy(xpath = "//*[text()='HP']"),            // and   --> logical AND
//            @FindBy(xpath = "//*[text()='Laptop']")
//    })

    // 2nd way
    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP') or contains(text(),'Laptop')or contains(text(),'laptop')])[1]")
//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP') or contains(text(),'Laptop')or contains(text(),'laptop')]
    // up this is the whole results/list

// 3rd way:  try to find better locator to locate the search results
// however, this one is good in terms of practising the "ignore case" in Xpath
//    @FindBy(xpath = "(//h2/a/span[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'hp laptop')])[2]")
    // this locator search WEs for provided String and ignore case sensitivity (if contains String & ignore case sens.)
    // this focus on String 'hp laptop' and ignore case sensitivity, however search may contain some results with other options...!!!
// span[@class='a-size-medium a-color-base a-text-normal'][ contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'laptop')or contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),HP)]
    // up this line refers to whole list, in order to select 1st one, need to modify -->  (this path)[1]
    public WebElement firstProductInSearchResults;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP') or contains(text(),'Laptop')or contains(text(),'laptop')]")
    public List<WebElement> searchProductList;


    ProductPage productPage = new ProductPage();

    public void selectCategoryForSearch(String category) {
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText(category);
        // verify category is actually selected)
//        select.getFirstSelectedOption();  // return the WE which is selected, we can use for verify after SELECTION in Dropdown
        Assert.assertEquals(category, select.getFirstSelectedOption().getText());
    }

    public void searchProduct(String product) {
        searchBar.sendKeys(product);
//        searchIcon.click();
        searchIcon.sendKeys(Keys.ENTER);
    }

    public void verifySearchResult(String product) {
//        Assert.assertEquals(product, searchResultMessage.getText());
//        Assert.assertEquals("\"" + product + "\"", searchResultMessage.getText());
        Assert.assertTrue(searchResultMessage.getText().contains(product));
    }

    public void clickFirstProduct() {
//        BrowserUtils.getPrintElementsText(searchProductList);            // MEB
        System.out.println(firstProductInSearchResults.getText());
        firstProductInSearchResults.click();
        productPage.addToListButton.click();     // if we dont mention explicitly add to which list, will add to default (1st) List...
        productPage.continue_shopping.click();

//        productPage.viewYourList.click();
//        productPage.wishListDropDown.click();  // if we have >1 list, and want to add to at a particular one, then can use this two lines
//        productPage.selectYourList.click();
    }


}
