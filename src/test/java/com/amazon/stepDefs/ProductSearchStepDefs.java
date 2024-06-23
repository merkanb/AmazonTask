package com.amazon.stepDefs;

import com.amazon.pages.ProductSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ProductSearchStepDefs {

    ProductSearchPage productSearchPage = new ProductSearchPage();

    @Given("the user selects product category {string} for search")
    public void the_user_selects_product_category_for_search(String category) {
        productSearchPage.selectCategoryForSearch(category);
    }

    @Given("the user searches for product {string}")
    public void the_user_searches_for_product(String product) {
        productSearchPage.searchProduct(product);
        productSearchPage.verifySearchResult(product);
    }

    @Given("the user selects the first product and adds it to the list")
    public void the_user_selects_the_first_product_and_adds_it_to_the_list() {
        productSearchPage.clickFirstProduct();
    }


    @And("the user selects the number {string} product and adds it to the list")
    public void theUserSelectsTheNumberProductAndAddsItToTheList(String number) {
        productSearchPage.addProductWithNumberInSearchResults(number);
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


}
