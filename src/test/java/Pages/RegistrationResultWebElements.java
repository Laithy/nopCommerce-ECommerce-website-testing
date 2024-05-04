package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class RegistrationResultWebElements {
    WebDriver driver;

    //Constructor
    public RegistrationResultWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }

    //Locators
    private WebElement resultMSG (){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }

    //Actions
    public String GetMsgText () {
        return resultMSG().getText();
    }
    public String GetMsgColor () {
        String color = resultMSG().getCssValue("color");
        return Color.fromString(color).asHex();
    }

}
