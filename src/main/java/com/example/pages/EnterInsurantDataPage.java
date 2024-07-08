package com.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterInsurantDataPage {
    private WebDriver driver;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "birthdate")
    private WebElement birthDate;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "occupation")
    private WebElement occupation;

    @FindBy(id = "bungeejumping")
    private WebElement bungeeJumpingCheckbox;

    @FindBy(id = "nextenterproductdata")
    private WebElement nextButton;

    public EnterInsurantDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInsurantData() {
        fillInsurantData("John", "Doe", "01/01/1990", "United States", "12345", "Employee", "Reading");
    }

    public void fillInsurantData(String firstName, String lastName, String birthDate, String country, String zipCode, String occupation, String hobbies) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(this.firstName)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(this.lastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(this.birthDate)).sendKeys(birthDate);
        wait.until(ExpectedConditions.visibilityOf(this.country)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOf(this.zipCode)).sendKeys(zipCode);
        wait.until(ExpectedConditions.visibilityOf(this.occupation)).sendKeys(occupation);

        if (hobbies.contains("Reading")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bungeeJumpingCheckbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bungeeJumpingCheckbox);
        }
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
