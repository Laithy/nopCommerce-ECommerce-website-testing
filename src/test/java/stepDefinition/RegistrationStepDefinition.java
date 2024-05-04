package stepDefinition;

import Pages.HomepageWebElements;
import Pages.RegisterPageWebElements;
import Pages.RegistrationResultWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RegistrationStepDefinition {
    WebDriver driver = null;
    RegisterPageWebElements regWE;
    HomepageWebElements homeWE;
    RegistrationResultWebElements regResWE;
    SoftAssert softAssert;

    @Given("User opens the browser_Registration feature")
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        regWE = new RegisterPageWebElements(driver);
        homeWE = new HomepageWebElements(driver);
        regResWE = new RegistrationResultWebElements(driver);
        softAssert = new SoftAssert();
    }
    @Given("User navigates to the website \"(.*)\" Registration feature$")
    public void user_navigates_to_the_Website (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        String currentWebsite = driver.getCurrentUrl();
        Assert.assertTrue(currentWebsite.contains(Website),"Website isn't right");
        Thread.sleep(1000);
    }
    @And("Clicks on register button from the homepage")
    public void clicks_on_the_register_button () throws InterruptedException {
        homeWE.ClickRegisterButton();
        Thread.sleep(1000);
    }
    @When("User selects the gender")
    public void user_selects_the_gender () {
        regWE.SelectGender();
    }
    @And("enters first name \"(.*)\"$")
    public void enters_first_name (String firstName) {
        regWE.EnterFirstname(firstName);
    }
    @And("enters last name \"(.*)\"$")
    public void enters_last_name (String lastName) {
        regWE.EnterLastname(lastName);
    }
    @And("enters date of birth \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void enters_date_of_birth (String day, String month, String year) {
        regWE.EnterBirthDate(day, month, year);
    }
    @And("enters a valid email \"(.*)\"$")
    public void enters_valid_email (String email) {
        regWE.EnterMail(email);
    }
    @And("enters a password \"(.*)\"$")
    public void enter_password (String password) {
        regWE.EnterPassword(password);
    }
    @And("enters the same password again \"(.*)\"$")
    public void re_enter_password (String password) {
        regWE.EnterPasswordConfirmation(password);
    }
    @And("click register")
    public void click_register () throws InterruptedException {
        regWE.ClickRegister();
        Thread.sleep(3000);
    }
    @Then("User should see a success message \"(.*)\"$")
    public void success_message (String msg) {
        softAssert.assertTrue(regResWE.GetMsgText().contains(msg),"Expected result doesn't equal the actual result");
    }
    @And("the color should be green hex code= \"(.*)\"$")
    public void success_msg_color (String expectedHex){
        softAssert.assertTrue(regResWE.GetMsgColor().contains(expectedHex));
    }
    @And("Closes the browser_Registration feature")
    public void close_driver () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        softAssert.assertAll();
    }
}
