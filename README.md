# Sauce Demo E2E Testing Project

This project contains end-to-end (E2E) tests for the Sauce Labs Demo App (https://www.saucedemo.com/). The tests are implemented using Selenium WebDriver with Java and TestNG framework.

## Test Scenarios

The following scenarios are covered in our E2E tests:

1. Login Functionality:
   - Test login with valid credentials
   - Test login with invalid credentials
   - Verify appropriate error messages for invalid login attempts

2. Product Page:
   - Verify all products are displayed correctly
   - Validate product details (name, price, and description)
   - Test sorting functionality by price

3. Shopping Cart:
   - Add a product to the cart and verify cart update
   - Remove a product from the cart and verify cart update
   - Verify shopping cart badge count updates correctly

4. User Logout:
   - Test logout functionality and redirection to login page

## Project Structure

- `src/main/java`: Contains the main source code
   - `com.saucedemo.config`: Configuration classes
   - `com.saucedemo.driver`: WebDriver factory and management
   - `com.saucedemo.pages`: Page Object Model classes
- `src/test/java`: Contains the test classes
   - `com.saucedemo.tests`: TestNG test classes

## Dependencies

- Selenium WebDriver
- TestNG
- Allure for reporting
- JavaFaker for generating test data

## Running the Tests

To run the tests, use the following command:
mvn clean test

## Generating Allure Reports

After running the tests, Allure results will be generated in the `allure-results` directory. To view the report, use the following command:
allure serve allure-results

This will start a local server and open the Allure report in your default web browser.

## Configuration

Test configuration is managed through the `appSettings.json` file located in `src/main/resources`. This file contains settings for:

- Browser type
- Application URL
- Test run type (local/remote)

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.