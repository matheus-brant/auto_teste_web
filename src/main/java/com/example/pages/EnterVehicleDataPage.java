package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterVehicleDataPage {
    private WebDriver driver;

    @FindBy(id = "make")
    private WebElement make;

    @FindBy(id = "engineperformance")
    private WebElement enginePerformance;

    @FindBy(id = "dateofmanufacture")
    private WebElement dateOfManufacture;

    @FindBy(id = "numberofseats")
    private WebElement numberOfSeats;

    @FindBy(id = "fuel")
    private WebElement fuelType;

    @FindBy(id = "listprice")
    private WebElement listPrice;

    @FindBy(id = "annualmileage")
    private WebElement annualMileage;

    @FindBy(id = "nextenterinsurantdata")
    private WebElement nextButton;

    public EnterVehicleDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillVehicleData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(make)).sendKeys("BMW");
        wait.until(ExpectedConditions.visibilityOf(enginePerformance)).sendKeys("333");
        wait.until(ExpectedConditions.visibilityOf(dateOfManufacture)).sendKeys("02/02/2020");
        wait.until(ExpectedConditions.visibilityOf(numberOfSeats)).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOf(fuelType)).sendKeys("Petrol");
        wait.until(ExpectedConditions.visibilityOf(listPrice)).sendKeys("20000");
        wait.until(ExpectedConditions.visibilityOf(annualMileage)).sendKeys("10000");
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
