package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPaymentInformationWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutPaymentInformationWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement selectCredWE () {
        return driver.findElement(By.cssSelector("select[id=\"CreditCardType\"]"));
    }
    public WebElement cardholderWE () {
        return driver.findElement(By.cssSelector("input[id=\"CardholderName\"]"));
    }
    public WebElement cardNumberWE () {
        return driver.findElement(By.cssSelector("input[id=\"CardNumber\"]"));
    }
    public WebElement expMonthWE () {
        return driver.findElement(By.cssSelector("select[id=\"ExpireMonth\"]"));
    }
    public WebElement expYearWE () {
        return driver.findElement(By.cssSelector("select[id=\"ExpireYear\"]"));
    }
    public WebElement cardCodeWE () {
        return driver.findElement(By.cssSelector("input[id=\"CardCode\"]"));
    }
    public WebElement continueButtonWE () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]"));
    }
}
