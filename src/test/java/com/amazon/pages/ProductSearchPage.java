package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ProductSearchPage extends BasePage {

    ProductPage productPage = new ProductPage();

    @FindBy(css = "#searchDropdownBox")
    public WebElement categoryDropdown;

    @FindBy(css = "#searchDropdownBox>option")
    public List<WebElement> allCategories;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchIcon;

    @FindBy(css = ".a-color-state.a-text-bold")
    public WebElement searchResultMessage;


    //    @FindBy(xpath = "(//div[@data-component-type='s-search-result'])[1]//span[@class='a-size-medium a-color-base a-text-normal']")
    @FindBy(xpath = "(//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement firstProductInSearchResults;


    //    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    @FindBy(xpath = "//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> productList;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP') or contains(text(),'Laptop')or contains(text(),'laptop')]")
    public List<WebElement> searchProductList;


    public void selectCategoryForSearch(String category) {
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText(category);
        Assert.assertEquals(category, select.getFirstSelectedOption().getText());
    }


    public void anyCategoryForSearch() {
        int randomCategoryIndex = random.nextInt(allCategories.size() - 1);
        Select select = new Select(categoryDropdown);
        select.selectByIndex(randomCategoryIndex);
    }


    public void searchProduct(String product) {
        searchBar.sendKeys(product);
        searchIcon.sendKeys(Keys.ENTER);
    }

    public void verifySearchResult(String product) {
//        Assert.assertTrue("\"" +product+"\"",searchResultMessage.getText();
        Assert.assertTrue(searchResultMessage.getText().contains(product));
    }

    public void clickFirstProduct() {
        firstProductInSearchResults.click();
//        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();
//        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }


    public void addProductWithNumberInSearchResults(String number) {
        WebElement withIndexSelectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal'])[" + number + "]"));
        withIndexSelectedProduct.click();
//        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();
//        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }

    Random random = new Random();

    public void selectARandomProduct() {
        int randomSelectProductIndex = random.nextInt(productList.size() - 1);          // productlist will optimized since have dif. structured categories
        WebElement randomSelectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal'])[\" + randomSelectProductIndex + \"]"));
        randomSelectedProduct.click();
    }


    public void addRandomProductInSearchResults() {
        selectARandomProduct();
        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();
        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }


    public void searchJustALetter() {
        int randomLetter = random.nextInt(65, 90);
        String asciiString = Character.toString((char) randomLetter);
        searchBar.clear();
        searchBar.sendKeys(String.valueOf(asciiString));
        searchIcon.sendKeys(Keys.ENTER);
    }


}
