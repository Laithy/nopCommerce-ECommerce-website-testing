package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutShippingMethodWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutShippingMethodWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement nextDayCheckboxWE () {
        return driver.findElement(By.cssSelector("input[id=\"shippingoption_1\"]"));
    }
    public WebElement continueButtonWE () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]"));
    }
}
