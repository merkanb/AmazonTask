package com.amazon.stepDefinitions;

import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductSearchPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProductSearchStepDefs {

    ProductSearchPage productSearchPage = new ProductSearchPage();
    ProductPage productPage = new ProductPage();

    @Given("the user selects product category {string} for search")
    public void the_user_selects_product_category_for_search(String category) {
        productSearchPage.selectCategoryForSearch(category);
    }

    @Given("the user searches for product {string}")
    public void the_user_searches_for_product(String product) {
        productSearchPage.searchProduct(product);
        productSearchPage.verifySearchResult(product);
    }

    @Given("the user selects the FIRST product and adds it to the list")
    public void the_user_selects_the_first_product_and_adds_it_to_the_list() {
        productSearchPage.clickFirstProduct();
    }

    @And("the user selects the {string} product and adds it to the list")
    public void theUserSelectsTheProductAndAddsItToTheList(String number) {
        productSearchPage.addProductWithNumberInSearchResults(number);
    }

    @And("the user selects the {string} product and adds it to the {string}")
    public void theUserSelectsTheProductAndAddsItToThe(String number, String WishListName) {
        WebElement withIndexSelectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal'])[" + number + "]"));
        withIndexSelectedProduct.click();
        productPage.selectAndAddListFromAddToListDropDown(WishListName);
    }

    @And("the user selects a RANDOM product and adds it to the list")
    public void theUserSelectsARandomProductAndAddsItToTheList() {
        productSearchPage.addRandomProductInSearchResults();
    }

    @And("the user selects ANY category for search")
    public void theUserSelectsANYCategoryForSearch() {
        productSearchPage.anyCategoryForSearch();
    }

    @And("the user searches just a LETTER for product")
    public void theUserSearchesJustALETTERForProduct() {
        productSearchPage.searchJustALetter();
    }


    @And("the user selects a RANDOM product and adds it to the {string}")
    public void the_user_selects_a_random_product_and_adds_it_to_the(String listName) {
        productSearchPage.selectARandomProduct();
//        BrowserUtils.waitFor(2);
        productPage.selectAndAddListFromAddToListDropDown(listName);
//        BrowserUtils.waitFor(2);
    }


    @And("the user selects the number {string} product and adds it to the {string}")
    public void theUserSelectsTheNumberProductAndAddsItToThe(String number, String listName) {
        WebElement withIndexSelectedProduct = Driver.get().findElement(By.xpath("(//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal'])[" + number + "]"));
        withIndexSelectedProduct.click();
//        BrowserUtils.waitFor(2);
        productPage.selectAndAddListFromAddToListDropDown(listName);
//        BrowserUtils.waitFor(2);
    }


}
