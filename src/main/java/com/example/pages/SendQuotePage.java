package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendQuotePage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "confirmpassword")
    WebElement confirmPassword;

    @FindBy(id = "sendemail")
    WebElement sendButton;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert') and contains(text(), 'Sending e-mail success!')]")
    WebElement successMessage;

    public SendQuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillQuoteData(String email, String phone, String username, String password, String confirmPassword) {
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void clickSend() {
        sendButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
}
