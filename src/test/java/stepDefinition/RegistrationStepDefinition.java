package stepDefinition;

import Pages.HomepageWebElements;
import Pages.RegisterPageWebElements;
import Pages.RegistrationResultWebElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class RegistrationStepDefinition {


    WebDriver driver = null;
    RegisterPageWebElements regWE;
    HomepageWebElements homeWE;
    RegistrationResultWebElements regResWE;


    @Before
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        regWE = new RegisterPageWebElements(driver);
        homeWE = new HomepageWebElements(driver);
        regResWE = new RegistrationResultWebElements(driver);
    }
    @Given("User navigates to the website \"(.*)\"$")
    public void user_navigates_to_the_Website (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @And("Clicks on register button from the homepage")
    public void clicks_on_the_register_button () throws InterruptedException {
        homeWE.regWE().click();
        Thread.sleep(1000);
    }
    @When("User selects the gender")
    public void user_selects_the_gender () throws InterruptedException {
        regWE.genderWE().click();
    }
    @And("enters first name \"(.*)\"$")
    public void enters_first_name (String firstName) throws InterruptedException {
        regWE.firstNameWE().clear();
        regWE.firstNameWE().sendKeys(firstName);
    }
    @And("enters last name \"(.*)\"$")
    public void enters_last_name (String lastName) throws InterruptedException {
        regWE.lastNameWE().clear();
        regWE.lastNameWE().sendKeys(lastName);
    }
    @And("enters date of birth \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void enters_date_of_birth (String day, String month, String year) throws InterruptedException {
        Select drpDay = new Select(regWE.day());
        drpDay.selectByValue(day);
        Select drpMonth = new Select(regWE.month());
        drpMonth.selectByVisibleText(month);
        Select drpYear = new Select(regWE.year());
        drpYear.selectByValue(year);
    }
    @And("enters a valid email \"(.*)\"$")
    public void enters_valid_email (String email) throws InterruptedException {
        regWE.emailWE().clear();
        regWE.emailWE().sendKeys(email);
    }
    @And("enters a password \"(.*)\"$")
    public void enter_password (String password) throws InterruptedException {
        regWE.passwordWE().clear();
        regWE.passwordWE().sendKeys(password);
    }
    @And("enters the same password again \"(.*)\"$")
    public void re_enter_password (String password) throws InterruptedException {
        regWE.confirmPasswordWE().clear();
        regWE.confirmPasswordWE().sendKeys(password);
    }
    @And("click register")
    public void click_register () throws InterruptedException {
        regWE.regButton().click();
        Thread.sleep(3000);
    }
    @Then("User should see a success message \"(.*)\"$")
    public void succsess_message (String msg) throws InterruptedException {
        Assert.assertTrue("Expected result doesn't equal the actual result",regResWE.resultMSG().getText().contains(msg));
    }
    @And("the color should be green hex code= \"(.*)\"$")
    public void succsess_msg_color (String expectedHex){
        String color = regResWE.resultMSG().getCssValue("color");
        String actualHex = Color.fromString(color).asHex();
        Assert.assertTrue(actualHex.contains(expectedHex));
    }
    @After
    public void close_driver () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
