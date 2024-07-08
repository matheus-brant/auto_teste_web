# Test Automation Technical Challenge

## Overview

This project is a test automation framework developed using Selenium WebDriver and Cucumber. The framework is designed to automate the end-to-end testing of a web application that deals with vehicle insurance data input and processing. The primary goal of the project is to ensure that all functionalities of the application work as expected, from entering vehicle data to submitting a quote request.

## Features

- **Page Object Model (POM)**: The project employs the Page Object Model design pattern to enhance the maintainability and readability of the test scripts.
- **Cucumber Integration**: Utilizes Cucumber to define test scenarios in a human-readable format using Gherkin syntax, enabling Behavior Driven Development (BDD).
- **WebDriver Management**: Manages WebDriver instances for browser automation, supporting multiple browsers.
- **Explicit Waits**: Implements explicit waits to handle dynamic web elements and ensure reliable test execution.
- **Form Automation**: Automates the process of filling out various forms within the application, including vehicle data, product data, and quote submission forms.
- **Error Handling**: Includes strategies for handling common Selenium exceptions such as `ElementClickInterceptedException` and `NoSuchElementException`.

## Installation

1. **Clone the Repository**

   ```sh
   git clone https://github.com/matheus-brant/auto_teste_web/
   cd auto_teste_web

2. **Set Up the Environment**

   Ensure you have the following installed:

   - Java JDK (version 11 or higher)
   - Maven
   - ChromeDriver (or the WebDriver for the browser you intend to use)
  
3. **Install Dependencies**

   ```sh
   mvn clean install
   ```

## Running the Tests

1. **Run All Tests**

To execute all tests defined in the project, use the following command:

   ```sh
   mvn test
   ```

2. **Generate Test Reports**

After running the tests, you can generate an HTML report using the following command:

   ```sh
   mvn verify
   ```

The report will be available in the target/cucumber-reports directory.

## Project Structure

- `src/main/java`: Contains the main code for the application (if any).
- `org/example`: Contains the main application class Main.java.
- `src/test/java`: Contains the test code, including:
  - `com/example/pages`: Page classes following the POM pattern.
  - `com/example/steps`: Step definition classes for Cucumber.
  - `com/example/runners`: Test runner classes to execute the Cucumber tests.
- `src/test/resources`: Contains Cucumber feature files written in Gherkin syntax.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## Fork the Project

1. Create your Feature Branch (git checkout -b feature/AmazingFeature)
2. Commit your Changes (git commit -m 'Add some AmazingFeature')
3. Push to the Branch (git push origin feature/AmazingFeature)
4. Open a Pull Request

