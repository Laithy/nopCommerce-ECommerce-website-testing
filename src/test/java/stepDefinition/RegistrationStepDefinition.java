package stepDefinition;

import Pages.HomepageWebElements;
import Pages.RegisterPageWebElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationStepDefinition {


    WebDriver driver = null;
    RegisterPageWebElements regWE;
    HomepageWebElements homeWE;


    @Before
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        regWE = new RegisterPageWebElements(driver);
        homeWE = new HomepageWebElements(driver);
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
    public void user_selects_the_gender (){
        regWE.genderWE().click();
    }
    @And("enters first name \"(.*)\"$")
    public void enters_first_name (String firstName){

    }
    @And("enters last name \"(.*)\"$")
    public void enters_last_name (String lastName){

    }
    @And("enters date of birth")
    public void enters_date_of_birth (){

    }
    @And("enters a valid email \"(.*)\"$")
    public void enters_valid_email (String email){

    }
    @And("enters a password \"(.*)\"$")
    public void enter_password (String password){

    }
    @And("enters the same password again \"(.*)\"$")
    public void re_enter_password (String password){

    }
    @Then("User should see a success message \"(.*)\"$")
    public void succsess_message (String msg){

    }
    @And("the color should be green hex code= \"(.*)\"$")
    public void succsess_msg_color (String colorHexCode){

    }
    @After
    public void close_driver () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
