package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageWebElements {
    WebDriver driver;

    //Constructor
    public HomepageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement regWE (){
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
}
