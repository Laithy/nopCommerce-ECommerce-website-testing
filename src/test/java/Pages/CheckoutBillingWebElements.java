package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutBillingWebElements {
    WebDriver driver;
    //Constructor
    public CheckoutBillingWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement firstNameWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_FirstName\"]"));
    }
    public WebElement lastNameWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_LastName\"]"));
    }
    public WebElement emailWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_Email\"]"));
    }
    public WebElement cityWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_City\"]"));
    }
    public WebElement addressWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_Address1\"]"));
    }
    public WebElement postalCodeWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_ZipPostalCode\"]"));
    }
    public WebElement phoneNumberWE () {
        return driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_PhoneNumber\"]"));
    }
    public WebElement countryWE () {
        return driver.findElement(By.cssSelector("select[data-trigger=\"country-select\"]"));
    }
    public WebElement continueButtonWE () {
        return driver.findElement(By.cssSelector("div[id=\"billing-buttons-container\"]>button[class=\"button-1 new-address-next-step-button\"]"));
    }

}
