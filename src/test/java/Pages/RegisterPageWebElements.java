package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageWebElements {
    WebDriver driver;

    //Constructor
    public RegisterPageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }

    //Locators
    private WebElement genderWE () {
        return driver.findElement(By.cssSelector("input[value=M]"));
    }
    private WebElement firstNameWE () {
        return driver.findElement(By.cssSelector("input[name=\"FirstName\"]"));
    }
    private WebElement lastNameWE () {
        return driver.findElement(By.cssSelector("input[name=\"LastName\"]"));
    }
    private WebElement emailWE () {
        return driver.findElement(By.cssSelector("input[name=\"Email\"]"));
    }
    private WebElement passwordWE () {
        return driver.findElement(By.cssSelector("input[name=\"Password\"]"));
    }
    private WebElement confirmPasswordWE () {
        return driver.findElement(By.cssSelector("input[name=\"ConfirmPassword\"]"));
    }
    private WebElement day (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }
    private WebElement month (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }
    private WebElement year (){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }
    private WebElement regButton (){
        return driver.findElement(By.cssSelector("button[name=\"register-button\"]"));
    }

    //Actions
    public void SelectGender () {
        genderWE().click();
    }
    public void EnterFirstname (String firstName) {
        firstNameWE().clear();
        firstNameWE().sendKeys(firstName);
    }
    public void EnterLastname (String lastName) {
        lastNameWE().clear();
        lastNameWE().sendKeys(lastName);
    }
    public void EnterMail (String mail) {
        emailWE().clear();
        emailWE().sendKeys(mail);
    }
    public void EnterPassword (String password){
        passwordWE().clear();
        passwordWE().sendKeys(password);
    }
    public void EnterPasswordConfirmation (String password){
        confirmPasswordWE().clear();
        confirmPasswordWE().sendKeys(password);
    }
    public void ClickRegister () {
        regButton().click();
    }
    public void EnterBirthDate (String day, String month, String year){
        Select drpDay = new Select(day());
        drpDay.selectByValue(day);
        Select drpMonth = new Select(month());
        drpMonth.selectByVisibleText(month);
        Select drpYear = new Select(year());
        drpYear.selectByValue(year);
    }

}
