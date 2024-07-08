package com.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterProductDataPage {
    private WebDriver driver;

    @FindBy(id = "startdate")
    private WebElement startDate;

    @FindBy(id = "insurancesum")
    private WebElement insuranceSum;

    @FindBy(id = "meritrating")
    private WebElement meritRating;

    @FindBy(id = "damageinsurance")
    private WebElement damageInsurance;

    @FindBy(id = "EuroProtection")
    private WebElement euroProtection;

    @FindBy(id = "courtesycar")
    private WebElement courtesyCar;

    @FindBy(id = "nextselectpriceoption")
    private WebElement nextButton;

    public EnterProductDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillProductData() {
        fillProductData("02/03/2025", "3000000", "Bonus 1", "Full Coverage", "Euro Protection", "Yes");
    }

    public void fillProductData(String startDate, String insuranceSum, String meritRating, String damageInsurance, String products, String courtesyCar) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(this.startDate)).sendKeys(startDate);
        wait.until(ExpectedConditions.visibilityOf(this.insuranceSum)).sendKeys(insuranceSum);
        wait.until(ExpectedConditions.visibilityOf(this.meritRating)).sendKeys(meritRating);
        wait.until(ExpectedConditions.visibilityOf(this.damageInsurance)).sendKeys(damageInsurance);

        if (products.contains("Euro Protection")) {
            wait.until(ExpectedConditions.visibilityOf(euroProtection));
            if (!euroProtection.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", euroProtection);
            }
        }
        wait.until(ExpectedConditions.visibilityOf(this.courtesyCar)).sendKeys(courtesyCar);
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}

