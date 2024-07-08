package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.example.pages.*;

public class Main {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathe\\Downloads\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void main(String[] args) {
        driver = getDriver();
        driver.manage().window().maximize(); // Maximizar o navegador

        try {
            driver.get("http://sampleapp.tricentis.com/101/app.php");

            EnterVehicleDataPage vehicleDataPage = new EnterVehicleDataPage(driver);
            vehicleDataPage.fillVehicleData();
            vehicleDataPage.clickNext();

            EnterInsurantDataPage insurantDataPage = new EnterInsurantDataPage(driver);
            insurantDataPage.fillInsurantData();
            insurantDataPage.clickNext();

            EnterProductDataPage productDataPage = new EnterProductDataPage(driver);
            productDataPage.fillProductData();
            productDataPage.clickNext();

            SelectPriceOptionPage priceOptionPage = new SelectPriceOptionPage(driver);
            priceOptionPage.selectPriceOption();
            priceOptionPage.clickNext();

            SendQuotePage sendQuotePage = new SendQuotePage(driver);
            sendQuotePage.fillQuoteData();
            sendQuotePage.clickSend();

            if (sendQuotePage.isSuccessMessageDisplayed()) {
                System.out.println("Quote sent successfully!");
            } else {
                System.out.println("Failed to send quote.");
            }
        } finally {
            // Deixe o navegador aberto para revisão
            // driver.quit();
        }
    }
}
