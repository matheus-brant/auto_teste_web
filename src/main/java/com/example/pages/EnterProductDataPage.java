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
    WebDriver driver;

    @FindBy(id = "startdate")
    WebElement startDate;

    @FindBy(id = "insurancesum")
    WebElement insuranceSum;

    @FindBy(id = "meritrating")
    WebElement meritRating;

    @FindBy(id = "damageinsurance")
    WebElement damageInsurance;

    @FindBy(id = "EuroProtection")
    WebElement euroProtection;

    @FindBy(id = "courtesycar")
    WebElement courtesyCar;

    @FindBy(id = "nextselectpriceoption")
    WebElement nextButton;

    public EnterProductDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillProductData(String date, String sum, String rating, String damage, String products, String car) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(startDate)).sendKeys(date);
        wait.until(ExpectedConditions.visibilityOf(insuranceSum)).sendKeys(sum);
        wait.until(ExpectedConditions.visibilityOf(meritRating)).sendKeys(rating);
        wait.until(ExpectedConditions.visibilityOf(damageInsurance)).sendKeys(damage);

        if (products.contains("Euro Protection")) {
            wait.until(ExpectedConditions.visibilityOf(euroProtection));
            if (!euroProtection.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", euroProtection);
            }
        }

        wait.until(ExpectedConditions.visibilityOf(courtesyCar)).sendKeys(car);
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
