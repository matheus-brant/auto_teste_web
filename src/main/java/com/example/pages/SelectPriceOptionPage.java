package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectPriceOptionPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='Select Option' and @value='Gold']/following-sibling::span[@class='ideal-radio']")
    WebElement goldOption;

    @FindBy(id = "nextsendquote")
    WebElement nextButton;

    public SelectPriceOptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPriceOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(goldOption)).click();
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
}
