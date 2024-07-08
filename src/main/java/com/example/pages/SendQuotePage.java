package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendQuotePage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmpassword")
    private WebElement confirmPassword;

    @FindBy(id = "sendemail")
    private WebElement sendButton;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert') and contains(text(), 'Sending e-mail success!')]")
    private WebElement successMessage;

    public SendQuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillQuoteData() {
        fillQuoteData("john.doe@example.com", "1234567890", "johndoe", "P4ssw0rd", "P4ssw0rd");
    }

    public void fillQuoteData(String email, String phone, String username, String password, String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(this.phone)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOf(this.username)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(this.confirmPassword)).sendKeys(confirmPassword);
    }

    public void clickSend() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
}
