Feature: Amazon E2E Test Feature


  @wip
  Scenario:Amazon E2E Test Scenario
    Given the user is on the login page
    And the user logs in successfully
    When the user creates a list named as "My Shopping List_1"
    When the user creates a list named as "My Shopping List_2"
    And the user selects product category "Computers & Accessories" for search
    And the user searches for product "hp laptop"
    And the user selects the first product and adds it to the list
#    And the user deletes the list "My Shopping List_2"
#    And the user deletes the list "My Shopping List_1"
    And the user logs out


  @wip2
  Scenario:Amazon Search result
    Given the user is on the login page
    And the user logs in successfully
    And the user selects product category "Computers & Accessories" for search
    And the user searches for product "hp laptop"
    And the user selects the first product and adds it to the list


  @test
  Scenario:Amazon Search result2
    Given the user is on the login page
    And the user logs in successfully
    When the user creates a list named as "My Shopping List2"
    And the user selects product category "Computers & Accessories" for search
    And the user searches for product "hp laptop"
    And the user selects the first product and adds it to the list
#    And the user delete the list from Homepage "My Shopping List2"
    And the user logs out



