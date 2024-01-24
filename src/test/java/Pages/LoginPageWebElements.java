package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageWebElements {
    WebDriver driver;

    //Constructor
    public LoginPageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement emailWB () {
        return driver.findElement(By.cssSelector("input[type=\"email\"]"));
    }
    public WebElement passwordWB () {
        return driver.findElement(By.cssSelector("input[type=\"password\"]"));
    }
    public WebElement loginButtonWB () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
    public WebElement failureMsgWB (){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}
