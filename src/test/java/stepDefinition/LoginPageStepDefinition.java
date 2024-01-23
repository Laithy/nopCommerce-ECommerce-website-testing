package stepDefinition;

import Pages.HomepageWebElements;
import Pages.LoginPageWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageStepDefinition {
    WebDriver driver = null;
    HomepageWebElements homeWE;
    LoginPageWebElements logWE;
    @Given("User opens the browser_Login feature")
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        homeWE = new HomepageWebElements(driver);
        logWE = new LoginPageWebElements(driver);
    }
    @Given("User navigates to the website \"(.*)\" LoginFeature$")
    public void user_navigates_to_the_Website (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @And("click on the login button")
    public void click_login_button () throws InterruptedException {
        homeWE.loginWE().click();
        Thread.sleep(1000);
    }
    @When("Login with email \"(.*)\"$")
    public void Login_email (String email){
        logWE.emailWB().clear();
        logWE.emailWB().sendKeys(email);
    }
    @And("Login with password \"(.*)\"$")
    public void Login_password (String password){
        logWE.passwordWB().clear();
        logWE.passwordWB().sendKeys(password);
    }
    @Then("Click on log in")
    public void Click_on_login () {
        logWE.loginButtonWB().click();
    }
    @And("Closes the browser_Login feature")
    public void close_driver () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
