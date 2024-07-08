package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterVehicleDataPage {
    WebDriver driver;

    @FindBy(id = "make")
    WebElement make;

    @FindBy(id = "model")
    WebElement model;

    @FindBy(id = "cylindercapacity")
    WebElement cylinderCapacity;

    @FindBy(id = "engineperformance")
    WebElement enginePerformance;

    @FindBy(id = "dateofmanufacture")
    WebElement dateOfManufacture;

    @FindBy(id = "numberofseats")
    WebElement numberOfSeats;

    @FindBy(id = "numberofseatsmotorcycle")
    WebElement numberOfSeatsMotorcycle;

    @FindBy(id = "fuel")
    WebElement fuelType;

    @FindBy(id = "payload")
    WebElement payload;

    @FindBy(id = "totalweight")
    WebElement totalWeight;

    @FindBy(id = "listprice")
    WebElement listPrice;

    @FindBy(id = "annualmileage")
    WebElement annualMileage;

    @FindBy(id = "nextenterinsurantdata")
    WebElement nextButton;

    public EnterVehicleDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillVehicleData(String make, String model, String cylinderCapacity, String enginePerformance,
                                String dateOfManufacture, String numberOfSeats, String numberOfSeatsMotorcycle,
                                String fuelType, String payload, String totalWeight, String listPrice, String annualMileage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(this.make)).sendKeys(make);
        wait.until(ExpectedConditions.visibilityOf(this.model)).sendKeys(model);
        wait.until(ExpectedConditions.visibilityOf(this.cylinderCapacity)).sendKeys(cylinderCapacity);
        wait.until(ExpectedConditions.visibilityOf(this.enginePerformance)).sendKeys(enginePerformance);
        wait.until(ExpectedConditions.visibilityOf(this.dateOfManufacture)).sendKeys(dateOfManufacture);
        wait.until(ExpectedConditions.visibilityOf(this.numberOfSeats)).sendKeys(numberOfSeats);
        wait.until(ExpectedConditions.visibilityOf(this.numberOfSeatsMotorcycle)).sendKeys(numberOfSeatsMotorcycle);
        wait.until(ExpectedConditions.visibilityOf(this.fuelType)).sendKeys(fuelType);
        wait.until(ExpectedConditions.visibilityOf(this.payload)).sendKeys(payload);
        wait.until(ExpectedConditions.visibilityOf(this.totalWeight)).sendKeys(totalWeight);
        wait.until(ExpectedConditions.visibilityOf(this.listPrice)).sendKeys(listPrice);
        wait.until(ExpectedConditions.visibilityOf(this.annualMileage)).sendKeys(annualMileage);
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
