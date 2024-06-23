
### www.amazon.co.uk Web Application Cucumber-JUnit & Selenium E2E Test Project

Codes and Tests Prepared by:
# M. Erkan BAS

# QA Test Automation Engineer

# merkanb@gmail.com   
# www.linkedin.com          

This file provides a basic outline to help you get started with Cucumber-JUnit & Selenium for E2E / End to End testing.

###  baseUrl:"https://www.amazon.co.uk"
email=merkanbtest@gmail.com
password=1234567Aa

### About Project

This project is a Cucumber BDD Test Framework in Java aiming testing www.amazon.co.uk Web Application with Cucumber-JUnit & Selenium with an approach of End to End Testing. 
Mostly focused on this web application: Category, Search Product and Wish List functionalities. (Wish List creating, adding product to list, Selecting any Category and any Product than adding to the list) 
Configuration properties file contains the url and valid credentials to be used in testing. Runners package includes CukesRunner class which triggers the tagged test scenarios and stepDefinitions package include related step definitions classes in which the hard coding for the scenarios defined.
Used Page Object Model pages, predefined locators and methods in order to achieve high usability and also maintainability. 

# General aspects of the project are:
• I built my framework using Java Programming Language.
• I used maven as a build automation tool for my java project.
• I used Cucumber-Junit and Cucumber runner to orchestrate tests.
• Inside the Cucumber runner, I used glues to connect feature files to step definitions.
• I added the report plugin to Cucumber Runner to generate Json and HTML report.
• I have a utilities package, which contains utility classes such as Configuration Reader.
• I am using Page Object Modelling to enhance test maintenance and reducing code duplication. This is one of the most famous Selenium approaches.
• I use Page Object Classes to store and identify the elements that I work on.
• I use the PageFactory class and initElements method to initialize them.
• I am using Cucumber and Gherkin language for non-technical people to understand what is going on in testing.
• To interact with browsers, I am utilizing Selenium WebDriver.
• I used the Singleton pattern by declaring constructor of class as private so that no one instantiates class outside of it. And declared a static method with return type as object of class which should check if class is already instantiated once.
• I have created my test cases in the feature files.
• I use hook class as pre-and post-test implementations.
• Step Definitions folder is the place where my actual test scripts are.
• For assertions/verifications, to compare expected and actual results I utilize Junit assertions.
• I also use tags for tests that I want to run.
• My framework is easy to maintain since I have elements stored in one centralized place. If any changes happen on the application about the elements, I know where to go and how to fix it to run test scripts correctly.


 # This E2E Test mainly have following steps in a bunch of Scenarios: 
 
- Navigate to amazon webpage (https://www.amazon.co.uk/) Use .properties file's reusable & maintainable environmental key and values
- If there are cookies options - accept them. 
- Login with valid credentials - (via .properties file)
- Create a shopping list and give a custom name to your list (with parameter / reusable)
- Select a certain category from the tab next to the search bar (in order to test all categories select category randomly)
- Verify the category is selected
- Search for a product e.g., "hp laptop" 
- Verify that the results message contains the searched text (hp laptop)
- Add the product to the shopping list that already created
- Delete list
- Sign Out and Verify that Sign out accomplished


![image](https://github.com/merkanb/AmazonTask/assets/134849499/652edad2-46af-4039-8795-19b231eadee1)


### Requirements
You must have the following installed on your machine:
- [IntelliJ](https://www.jetbrains.com/idea/)
- [Java 8 or later](https://www.java.com/en/download/)

Running the Project: To run either on terminal or via  IDE (IntelliJ IDEA) is possible. 



I welcome contributions! Feel free to modify this project template according to the specific needs of your project. Thank you.

2024 June &reg;

### End
