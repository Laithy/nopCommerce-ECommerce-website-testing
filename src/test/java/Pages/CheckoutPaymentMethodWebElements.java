package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPaymentMethodWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutPaymentMethodWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement continueButtonWE () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]"));
    }
    public WebElement creditCardWE () {
        return driver.findElement(By.cssSelector("input[id=\"paymentmethod_1\"]"));
    }
}
