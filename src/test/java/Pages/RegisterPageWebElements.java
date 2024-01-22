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
    public WebElement firstNameWE () {
        return driver.findElement(By.cssSelector("input[name=\"FirstName\"]"));
    }
    public WebElement lastNameWE () {
        return driver.findElement(By.cssSelector("input[name=\"LastName\"]"));
    }
    public WebElement emailWE () {
        return driver.findElement(By.cssSelector("input[name=\"Email\"]"));
    }
    public WebElement passwordWE () {
        return driver.findElement(By.cssSelector("input[name=\"Password\"]"));
    }
    public WebElement confirmPasswordWE () {
        return driver.findElement(By.cssSelector("input[name=\"ConfirmPassword\"]"));
    }
    public WebElement day (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }
    public WebElement month (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }
    public WebElement year (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }
    public WebElement regButton (){
        return driver.findElement(By.cssSelector("button[name=\"register-button\"]"));
    }

}
