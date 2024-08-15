Sauce Labs Demo App E2E Test Suite
Overview
Welcome to the Sauce Labs Demo App E2E Test Suite! This project contains end-to-end tests for the Sauce Labs Demo App, which allows you to verify various functionalities of the application. Below, you will find a detailed description of the implemented tests, the technologies used, and instructions for generating reports.

Application Under Test
URL: Sauce Labs Demo App
Test Scenarios
1. Login Functionality
   Valid Login: Tests successful login with valid credentials.
   Invalid Login: Tests login with invalid credentials and ensures appropriate error messages are displayed.
2. Product Page
   Product Display: Verifies that all products are displayed correctly.
   Product Details: Validates product details including name, price, and description.
   Sorting Functionality: Ensures products are sorted correctly by price.
3. Shopping Cart
   Add to Cart: Tests adding a product to the shopping cart and verifies the cart is updated.
   Remove from Cart: Tests removing a product from the shopping cart and ensures the cart updates correctly.
   Badge Count: Verifies that the shopping cart badge count updates correctly when items are added or removed.
4. User Logout
   Logout Functionality: Ensures that users are redirected to the login page after logging out.
   Technologies Used
   Test Framework: TestNG
   Reporting: Allure Reporting
   Browser Automation: Selenium WebDriver
   Test Runner: Java
   Getting Started
   Prerequisites
   Java 21 or later
   Maven or Gradle
   Selenium WebDriver
   Allure Commandline Tool
   Setup
   Clone the Repository:

bash
Copy code
git clone <repository-url>
cd <repository-directory>
Install Dependencies:
Make sure to have the necessary dependencies by running:

bash
Copy code
mvn install
Run Tests:
To execute the tests, use the following command:

bash
Copy code
mvn test
Generate Allure Report:
After running the tests, generate and view the Allure report using the command:

bash
Copy code
allure serve allure-results
Troubleshooting
If you encounter any issues or errors, ensure that:

The appSettings.json file is correctly configured with the necessary test settings.
The Allure command line tool is installed and properly configured.