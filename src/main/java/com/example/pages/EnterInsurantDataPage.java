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
    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "birthdate")
    WebElement birthDate;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "zipcode")
    WebElement zipCode;

    @FindBy(id = "occupation")
    WebElement occupation;

    @FindBy(xpath = "//input[@id='bungeejumping']")
    WebElement bungeeJumpingCheckbox;

    @FindBy(id = "nextenterproductdata")
    WebElement nextButton;

    public EnterInsurantDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInsurantData(String firstName, String lastName, String birthDate, String country, String zipCode, String occupation, String hobbies) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(this.firstName)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(this.lastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(this.birthDate)).sendKeys(birthDate);
        wait.until(ExpectedConditions.visibilityOf(this.country)).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOf(this.zipCode)).sendKeys(zipCode);
        wait.until(ExpectedConditions.visibilityOf(this.occupation)).sendKeys(occupation);

        if (hobbies.contains("Bungee Jumping")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.bungeeJumpingCheckbox);
            wait.until(ExpectedConditions.elementToBeClickable(this.bungeeJumpingCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", this.bungeeJumpingCheckbox);
        }
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
