package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutLoginWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutLoginWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement checkoutGuestWE () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 checkout-as-guest-button\"]"));
    }
}
