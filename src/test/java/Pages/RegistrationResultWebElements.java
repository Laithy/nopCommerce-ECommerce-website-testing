package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationResultWebElements {
    WebDriver driver;

    //Constructor
    public RegistrationResultWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement resultMSG (){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }
}
