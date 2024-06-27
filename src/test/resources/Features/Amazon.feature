Feature: Amazon E2E List Feature

# Navigate to amazon webpage (https://www.amazon.co.uk/)
# If there are cookies - accept
# Login with valid credentials
# Create a shopping list
# Select a category from the tab next to the search bar
# Verify the category is selected
# Search for a product e.g., "hp"
# Verify that the results message contains the searched text (hp)
# Click first product from the search result list
# Add the product to the shopping list you created
# Delete list
# Logout

  Background:
    Given the user is on the login page
    And the user logs in successfully


  @addFirst
  Scenario:Amazon E2E Add Fist Product Scenario
    When the user creates a list named as "My Shopping List_1"
    When the user creates a list named as "My Shopping List_2"
    And the user selects product category "Computers & Accessories" for search
    And the user searches for product "hp laptop"
    And the user selects the FIRST product and adds it to the list
    And the user deletes the list "My Shopping List_2"
    And the user deletes the list "My Shopping List_1"
    And the user logs out


  @addWithNumber
  Scenario Outline:Amazon E2E Add Product With Number Scenario Outline
    When the user creates a list named as "Family Wish List"
    When the user creates a list named as "Kids Wish List"
    And the user selects product category "Home & Kitchen" for search
    And the user searches for product "<Home & Kitchen Product>"
    And the user selects the "<number>" product and adds it to the list
    And the user deletes the list "Family Wish List"
    And the user deletes the list "Kids Wish List"
    And the user logs out

    Examples:
      | Home & Kitchen Product | number |
      | kids tablet            | 3      |
      | ice cube maker         | 2      |
      | kettles electric       | 3      |


  @addRandom
  Scenario:Amazon E2E Add Random Product Scenario
    When the user creates a list named as "Company Wish List"
    When the user creates a list named as "Family Wish List"
    And the user selects product category "Books" for search
    And the user searches for product "autobiography books bestsellers"
    And the user selects a RANDOM product and adds it to the list
    And the user deletes the list "Family Wish List"
    And the user deletes the list "Company Wish List"
    And the user logs out


  @addRandomToParticularList
  Scenario:Amazon E2E Add Random Product Scenario
    When the user creates a list named as "Company Wish List"
    When the user creates a list named as "Family Wish List"
    And the user selects product category "DVD & Blu-ray" for search
    And the user searches for product "Ghostbusters"
    And the user selects a RANDOM product and adds it to the "Family Wish List"
    And the user deletes the list "Company Wish List"
    And the user deletes the list "Family Wish List"
    And the user logs out


  @searchAnyLetter
  Scenario:Amazon E2E Add Random Product From any Category Scenario
    When the user creates a list named as "Common List"
    When the user creates a list named as "Private List"
    And the user selects product category "Books" for search
    And the user searches just a LETTER for product
    And the user selects the "2" product and adds it to the list
    And the user selects product category "Books" for search
    And the user searches just a LETTER for product
    And the user selects a RANDOM product and adds it to the "Private List"
    And the user deletes the list "Common List"
    And the user deletes the list "Private List"
    And the user logs out


  @addFromAnyCategory
  Scenario:Amazon E2E Add Random Product From any Category Scenario
    When the user creates a list named as "Common List"
    When the user creates a list named as "Private List"
#    And the user selects ANY category for search
    And the user searches just a LETTER for product
    And the user selects the "2" product and adds it to the list
#    And the user selects ANY category for search
    And the user searches just a LETTER for product
    And the user selects a RANDOM product and adds it to the "Private List"
    And the user deletes the list "Common List"
    And the user deletes the list "Private List"
    And the user logs out