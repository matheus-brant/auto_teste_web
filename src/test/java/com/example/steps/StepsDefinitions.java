package com.example.steps;

import com.example.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class StepsDefinitions {
    WebDriver driver;
    EnterVehicleDataPage vehicleDataPage;
    EnterInsurantDataPage insurantDataPage;
    EnterProductDataPage productDataPage;
    SelectPriceOptionPage priceOptionPage;
    SendQuotePage sendQuotePage;

    public StepsDefinitions() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathe\\Downloads\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        vehicleDataPage = PageFactory.initElements(driver, EnterVehicleDataPage.class);
        insurantDataPage = PageFactory.initElements(driver, EnterInsurantDataPage.class);
        productDataPage = PageFactory.initElements(driver, EnterProductDataPage.class);
        priceOptionPage = PageFactory.initElements(driver, SelectPriceOptionPage.class);
        sendQuotePage = PageFactory.initElements(driver, SendQuotePage.class);
    }

    @Given("the user is on the tricentis vehicle data page")
    public void theUserIsOnTheTricentisVehicleDataPage() {
        driver.get("http://sampleapp.tricentis.com/101/app.php");
    }

    @When("the user enters vehicle data {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void theUserEntersVehicleData(String make, String model, String cylinderCapacity, String enginePerformance,
                                         String dateOfManufacture, String numberOfSeats, String numberOfSeatsMotorcycle,
                                         String fuelType, String payload, String totalWeight, String listPrice, String annualMileage) {
        vehicleDataPage.fillVehicleData(make, model, cylinderCapacity, enginePerformance, dateOfManufacture,
                numberOfSeats, numberOfSeatsMotorcycle, fuelType, payload, totalWeight, listPrice, annualMileage);
    }

    @When("the user clicks next on vehicle data page")
    public void theUserClicksNextOnVehicleDataPage() {
        vehicleDataPage.clickNext();
    }

    @When("the user enters insurant data {string} {string} {string} {string} {string} {string} {string}")
    public void theUserEntersInsurantData(String firstName, String lastName, String birthDate, String country, String zipCode, String occupation, String hobbies) {
        insurantDataPage.fillInsurantData(firstName, lastName, birthDate, country, zipCode, occupation, hobbies);
    }

    @When("the user clicks next on insurant data page")
    public void theUserClicksNextOnInsurantDataPage() {
        insurantDataPage.clickNext();
    }

    @When("the user enters product data {string} {string} {string} {string} {string} {string}")
    public void theUserEntersProductData(String startDate, String insuranceSum, String meritRating, String damageInsurance, String optionalProducts, String courtesyCar) {
        productDataPage.fillProductData(startDate, insuranceSum, meritRating, damageInsurance, optionalProducts, courtesyCar);
    }

    @When("the user clicks next on product data page")
    public void theUserClicksNextOnProductDataPage() {
        productDataPage.clickNext();
    }

    @When("the user selects a price option")
    public void theUserSelectsAPriceOption() {
        priceOptionPage.selectPriceOption();
    }

    @When("the user clicks next on price option page")
    public void theUserClicksNextOnPriceOptionPage() {
        priceOptionPage.clickNext();
    }

    @When("the user enters quote data {string} {string} {string} {string} {string}")
    public void theUserEntersQuoteData(String email, String phone, String username, String password, String confirmPassword) {
        sendQuotePage.fillQuoteData(email, phone, username, password, confirmPassword);
    }

    @When("the user clicks send")
    public void theUserClicksSend() {
        sendQuotePage.clickSend();
    }

    @Then("the user should see the success message")
    public void theUserShouldSeeTheSuccessMessage() {
        Assert.assertTrue(sendQuotePage.isSuccessMessageDisplayed());
        driver.quit();
    }
}
