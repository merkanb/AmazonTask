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


    @FindBy(xpath = "(//div[@data-component-type='s-search-result'])[1]//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement firstProductInSearchResults;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
//    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> productList;


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'HP') or contains(text(),'Laptop')or contains(text(),'laptop')]")
    public List<WebElement> searchProductList;


    ProductPage productPage = new ProductPage();

    public void selectCategoryForSearch(String category) {
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText(category);
        Assert.assertEquals(category, select.getFirstSelectedOption().getText());
    }

    public void searchProduct(String product) {
        searchBar.sendKeys(product);
        searchIcon.sendKeys(Keys.ENTER);
    }

    public void verifySearchResult(String product) {
        Assert.assertTrue(searchResultMessage.getText().contains(product));
    }

    public void clickFirstProduct() {
        firstProductInSearchResults.click();
        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();     // if we do not mention explicitly add to which list, will add to default (1st) List...
        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }

    public void addProductWithNumberInSearchResults(String number) {
        WebElement selectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result'])[" + number + "]//span[@class='a-size-medium a-color-base a-text-normal']"));
        selectedProduct.click();
        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();     // if we do not mention explicitly add to which list, will add to default (1st) List...
        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }

    Random random = new Random();

    public void addRandomProductInSearchResults() {          // productlist will optimized since have dif. structured categories
        int randomSelectProductIndex = random.nextInt(productList.size() - 1);
        WebElement randomSelectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result'])[" + randomSelectProductIndex + "]//span[@class='a-size-medium a-color-base a-text-normal']"));
        randomSelectedProduct.click();
        BrowserUtils.waitFor(2);
        productPage.addToListButton.click();     // if we do not mention explicitly add to which list, will add to default (1st) List...
        BrowserUtils.waitFor(2);
        productPage.continue_shopping.click();
    }


    public void anyCategoryForSearch() {
        int randomCategoryIndex;
        for (int i = 0; i < 999; i++) {
            randomCategoryIndex = random.nextInt(allCategories.size() - 1);
            if (18 >= randomCategoryIndex || randomCategoryIndex >= 25) {
                Select select = new Select(categoryDropdown);
                select.selectByIndex(randomCategoryIndex);
                break;
            }
        }
    }



    public void searchJustALetter() {
        int randomLetter = random.nextInt(65, 90);
        String asciiString = Character.toString((char) randomLetter);
        searchBar.clear();
        searchBar.sendKeys(String.valueOf(asciiString));
        searchIcon.sendKeys(Keys.ENTER);
    }


//        productPage.viewYourList.click();
//        productPage.wishListDropDown.click();  // if we have >1 list, and want to add to at a particular one, then can use this two lines
//        productPage.selectYourList.click();


}
