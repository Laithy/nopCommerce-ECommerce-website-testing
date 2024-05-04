package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class LoginPageWebElements {
    WebDriver driver;

    //Constructor
    public LoginPageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }

    //Locators
    private WebElement emailWB () {
        return driver.findElement(By.cssSelector("input[type=\"email\"]"));
    }
    private WebElement passwordWB () {
        return driver.findElement(By.cssSelector("input[type=\"password\"]"));
    }
    private WebElement loginButtonWB () {
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
    private WebElement failureMsgWB (){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
    private WebElement headerWB () {
        return driver.findElement(By.cssSelector("div[class=\"header-links-wrapper\"]"));
    }

    //Actions
    public void EnterMail (String mail) {
        emailWB().clear();
        emailWB().sendKeys(mail);
    }
    public void EnterPassword (String password) {
        passwordWB().clear();
        passwordWB().sendKeys(password);
    }
    public void ClickLoginButton () {
        loginButtonWB().click();
    }
    public String GetMsgText () {
        return failureMsgWB().getText();
    }
    public String GetMsgColor () {
        String color = failureMsgWB().getCssValue("color");
        return Color.fromString(color).asHex();
    }
    public String GetHeaderText () {
        return headerWB().getText();
    }
}
