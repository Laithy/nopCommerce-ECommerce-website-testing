package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartWebElements {
    WebDriver driver;
    //Constructor
    public CartWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement termsCheckboxWE () {
        return driver.findElement(By.cssSelector("input[id=\"termsofservice\"]"));
    }
    public WebElement checkoutButtonWE () {
        return driver.findElement(By.cssSelector("button[id=\"checkout\"]"));
    }

}
