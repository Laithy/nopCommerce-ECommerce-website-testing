package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutConfirmOrderWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutConfirmOrderWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement confirmButtonWE () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 confirm-order-next-step-button\"]"));
    }
}
