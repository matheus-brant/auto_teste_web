package com.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.example.Main;
import com.example.pages.*;

public class StepsDefinitions {
    private WebDriver driver;
    private EnterVehicleDataPage vehicleDataPage;
    private EnterInsurantDataPage insurantDataPage;
    private EnterProductDataPage productDataPage;
    private SelectPriceOptionPage priceOptionPage;
    private SendQuotePage sendQuotePage;
    private boolean isFinalTest = false;
    private boolean happyPathCompleted = false;

    @Before
    public void setUp() {
        driver = Main.getDriver();
        driver.manage().window().maximize();
        driver.get("http://sampleapp.tricentis.com/101/app.php");
    }

    @After
    public void tearDown() {
        if (!isFinalTest && !happyPathCompleted) {
            driver.navigate().refresh();
        } else if (!happyPathCompleted) {
            driver.quit();
        }
    }

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String page) {
        switch (page) {
            case "vehicle data":
                vehicleDataPage = new EnterVehicleDataPage(driver);
                break;
            case "insurant data":
                vehicleDataPage = new EnterVehicleDataPage(driver);
                vehicleDataPage.fillVehicleData();
                vehicleDataPage.clickNext();
                insurantDataPage = new EnterInsurantDataPage(driver);
                break;
            case "product data":
                vehicleDataPage = new EnterVehicleDataPage(driver);
                vehicleDataPage.fillVehicleData();
                vehicleDataPage.clickNext();
                insurantDataPage = new EnterInsurantDataPage(driver);
                insurantDataPage.fillInsurantData();
                insurantDataPage.clickNext();
                productDataPage = new EnterProductDataPage(driver);
                break;
            case "price option":
                vehicleDataPage = new EnterVehicleDataPage(driver);
                vehicleDataPage.fillVehicleData();
                vehicleDataPage.clickNext();
                insurantDataPage = new EnterInsurantDataPage(driver);
                insurantDataPage.fillInsurantData();
                insurantDataPage.clickNext();
                productDataPage = new EnterProductDataPage(driver);
                productDataPage.fillProductData();
                productDataPage.clickNext();
                priceOptionPage = new SelectPriceOptionPage(driver);
                break;
            case "send quote":
                vehicleDataPage = new EnterVehicleDataPage(driver);
                vehicleDataPage.fillVehicleData();
                vehicleDataPage.clickNext();
                insurantDataPage = new EnterInsurantDataPage(driver);
                insurantDataPage.fillInsurantData();
                insurantDataPage.clickNext();
                productDataPage = new EnterProductDataPage(driver);
                productDataPage.fillProductData();
                productDataPage.clickNext();
                priceOptionPage = new SelectPriceOptionPage(driver);
                priceOptionPage.selectPriceOption();
                priceOptionPage.clickNext();
                sendQuotePage = new SendQuotePage(driver);
                break;
            default:
                throw new IllegalArgumentException("Unknown page: " + page);
        }
    }

    @When("I enter vehicle data")
    public void i_enter_vehicle_data() {
        vehicleDataPage.fillVehicleData();
        vehicleDataPage.clickNext();
    }

    @When("I enter insurant data")
    public void i_enter_insurant_data() {
        insurantDataPage.fillInsurantData();
        insurantDataPage.clickNext();
    }

    @When("I enter product data")
    public void i_enter_product_data() {
        productDataPage.fillProductData();
        productDataPage.clickNext();
    }

    @When("I select a price option")
    public void i_select_a_price_option() {
        priceOptionPage.selectPriceOption();
        priceOptionPage.clickNext();
    }

    @When("I enter quote data")
    public void i_enter_quote_data() {
        sendQuotePage.fillQuoteData();
        sendQuotePage.clickSend();
    }

    @When("I complete the happy path")
    public void i_complete_the_happy_path() {
        vehicleDataPage.fillVehicleData();
        vehicleDataPage.clickNext();
        insurantDataPage.fillInsurantData();
        insurantDataPage.clickNext();
        productDataPage.fillProductData();
        productDataPage.clickNext();
        priceOptionPage.selectPriceOption();
        priceOptionPage.clickNext();
        sendQuotePage.fillQuoteData();
        sendQuotePage.clickSend();
        happyPathCompleted = true;
    }

    @When("I enter invalid first name {string}")
    public void i_enter_invalid_first_name(String firstName) {
        vehicleDataPage.fillVehicleData();
        vehicleDataPage.clickNext();
        insurantDataPage.fillInsurantData(firstName, "Doe", "01/01/1990", "United States", "12345", "Employee", "Reading");
        insurantDataPage.clickNext();
    }

    @When("I enter invalid password {string}")
    public void i_enter_invalid_password(String password) {
        vehicleDataPage.fillVehicleData();
        vehicleDataPage.clickNext();
        insurantDataPage.fillInsurantData();
        insurantDataPage.clickNext();
        productDataPage.fillProductData();
        productDataPage.clickNext();
        priceOptionPage.selectPriceOption();
        priceOptionPage.clickNext();
        sendQuotePage.fillQuoteData("john.doe@example.com", "1234567890", "johndoe", password, password);
        sendQuotePage.clickSend();
    }

    @Then("An error message should be displayed for first name")
    public void an_error_message_should_be_displayed_for_first_name() {
        // Validação da mensagem de erro
    }

    @Then("An error message should be displayed for password")
    public void an_error_message_should_be_displayed_for_password() {
        // Validação da mensagem de erro
    }

    @Then("I should be able to proceed to the next page")
    public void i_should_be_able_to_proceed_to_the_next_page() {
        // Validação para garantir a navegação para a próxima página
    }

    @Then("The quote should be sent")
    public void the_quote_should_be_sent() {
        isFinalTest = true; // Marcar como o último teste para encerrar o navegador
        // Validação do envio da cotação
    }
}
