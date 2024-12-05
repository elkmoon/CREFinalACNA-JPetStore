**CREFinalACNA - Certificação Rumos Expert (CRE): Test Automation Engineer - JPetStore ACNA 🏁**

Introduction
============
  To achieve the "CRE - Certificação Rumos Expert (CRE): Test Automation Engineer" certification the student must implement and execute a project regarding test automation.
  
  This document defines guidelines and requirements of the final project for obtaining the CRE - Certificação Rumos Expert (CRE): Test Automation Engineer, as well as the project results and conclusions.

## 🌐 Project execution requirements and goals:

**Select an e-commerce website of your choice that meets specific requirements, such as:**

**User Registration:**

The website must allow a user to create an account by providing a name, email address, and password.

**User Authentication:**
The website must allow a user to authenticate their account by providing a username and password.

**Product Search and Viewing:**
The website must have a search bar where the user can search for products.
The search results must be displayed correctly, including information such as the product name, price, and description.
The user must be able to view the details of a selected product.

**Adding Items to Shopping Cart:**

The user must be able to add items to the shopping cart from the product detail page.
The items added must be correctly displayed in the shopping cart.

**Checkout Process:**
The user must authenticate on the platform.
The user should select a product.
The user must be able to proceed to checkout from the shopping cart.
The website must request payment information and delivery address.
After completing the purchase, the user should receive a purchase confirmation.

**Other Project Requirements:**

:black_small_square: Implementation with selenium webdriver

:black_small_square: Use of Page Object Models 

:black_small_square: Assure code Maintenance and Reusability

:black_small_square:Implementation of Independent and Isolated Tests 

:black_small_square:Execution in Multiple Browsers

:black_small_square:Allure Report Integration 

:black_small_square:Test Execution in Jenkins


## 🔧 Tools and preconditions used in the project execution

:eject_button:**Preconditions:**

:black_small_square:  **E-commerce website chosen to be used:**
  https://petstore.octoperf.com/actions/Catalog.action

:eject_button:**Tools:**

 :black_small_square: **IDE** :Eclipse 
  
 :black_small_square: **Frameworks used:** Selenium, Cucumber
  
 :black_small_square: **Testing framework:** TestNG, Allure Report, JUnit
  
 :black_small_square: **Programming language:** JAVA
  
 :black_small_square: **Build tool:** Maven
  
 :black_small_square: **CI/CD Tool:** Jenkins
  
 :black_small_square: **Repository:** GitHub


## 📑 Requirements to replicate this project:

In order to replicate this project, the user should have:

:black_small_square:JDK 21 or higher

:black_small_square:Maven 3.9.9

:black_small_square:IDE: compatible with Selenium (eg. *IntellIJ* , *Eclipse*, *Aqua*)

:black_small_square: *TestNg*, *JUnit*, *Cucumber* installed

:black_small_square: Allure 2.32.0 installed 

:black_small_square:Jenkins

:black_small_square:Git

Project Conclusions:
============

### The logic behind running the tests in this project

To run all the tests, run the command "**mvn clean test**" on the project terminal.

We used only one @tag (@Petstore) in order to run all tests at once, but you can also run each test individually by changing the individual @tag (in each feature, in the "features" folder) and adding the new @tags to the TestRunner class.

### 💡 Logic used behind organizing the project (options and choices made regarding its structure and execution)

In order to organize the project, I used the **Page Object Model**, so that each feature to be tested, was implemented
independently and all the test could also be run also individually. 

By using Page Object Model I could also can reuse code, making the project cleaner and easier to maintain the tests.

For each feature to be tested, i created different features files - written using **Gherkin language** -, with different  test cases and scenarios.

By using scenario outline, I could specify steps for testing using different data sets.

To safeguard code  maintainability, and create reusable code i should to implement some artifacts that are common to all tests:

I choose to create:

:black_small_square:An **HomepageSteps** because there a common steps in all test: all of them begin in the homepage. By using this approach i can reuse and handle this step in all scenarios.

:black_small_square:To implement a TextContent package and class to share states between features and steps, in order to use the webdriver across the test. This way, instead of always
creating a separate instance for the WebDriver, i can centralize the logic for initializing and accessing the WebDriver in one place.

:black_small_square:Also by creating and **browserConfiguration** package and class i could reunite in one place the configurations regarding the browsers where the tests will run.

**NOTE:** I tried to run all tests in **Chrome**, **Firefox** and **Edge**, and all did, successfully, locally.

When i tried to run them in **Jenkins**, the "Edge" browser did not work. I tried to find a solution, but unsuccessfully. I think it might pertain to the information being sent to fast and the browser can detect what is being written, but even by using **slow keys** to slow down the speed of send_keys actions in **selenium**, it did not solve it. 
i will revisit it in the future.

I know that in an ideal world, the code should always be clear enough to express itself. If you write the code in a clear and descriptive manner, you do not need comments. 

In spite of that, and since the tests run on all browsers, for instance, in IDE Eclipse, while running "mvn clean test" in terminal (locally), and although i could not fix this problem, i kept the "edge" browser configuration code commented, so that a user can, if he wants, remove the commented code and easily run them in terminal. 
