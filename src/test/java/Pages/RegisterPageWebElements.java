package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageWebElements {
    WebDriver driver;

    //Constructor
    public RegisterPageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    //Username Locator
    public WebElement genderWE () {
        return driver.findElement(By.cssSelector("input[value=M]"));
    }

}
