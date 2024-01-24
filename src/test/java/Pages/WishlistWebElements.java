package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistWebElements {
    WebDriver driver;
    //Constructor
    public WishlistWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement productNameWE () {
        return driver.findElement(By.cssSelector("td[class=\"product\"]"));
    }
}
