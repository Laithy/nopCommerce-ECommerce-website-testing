package stepDefinition;

import Pages.HomepageWebElements;
import Pages.LoginPageWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class LoginPageStepDefinition {
    WebDriver driver = null;
    HomepageWebElements homeWE;
    LoginPageWebElements logWE;
    SoftAssert soft;

    @Given("User opens the browser_Login feature")
    public void init_driver (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        homeWE = new HomepageWebElements(driver);
        logWE = new LoginPageWebElements(driver);
        soft = new SoftAssert();
    }
    @Given("User navigates to the website \"(.*)\" LoginFeature$")
    public void user_navigates_to_the_Website (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @And("click on the login button")
    public void click_login_button () throws InterruptedException {
        homeWE.ClickLoginButton();
        Thread.sleep(1000);
    }
    @When("Login with email \"(.*)\"$")
    public void Login_email (String email){
        logWE.EnterMail(email);
    }
    @And("Login with password \"(.*)\"$")
    public void Login_password (String password){
        logWE.EnterPassword(password);
    }
    @Then("Click on log in")
    public void Click_on_login () throws InterruptedException {
        logWE.ClickLoginButton();
        Thread.sleep(3000);
    }
    @And("assert positive scenario")
    public void assert_positive (){
        soft.assertTrue(logWE.GetHeaderText().contains("Log out"),"Logout button was not found");
        soft.assertTrue(logWE.GetHeaderText().contains("My account"),"My account button was not found");
    }
    @And ("assert negative scenario \"(.*)\" \"(.*)\"$")
    public void assert_negative (String actualMsg , String hexCode){
        soft.assertTrue(logWE.GetMsgText().contains(actualMsg));
        soft.assertTrue(hexCode.contains(logWE.GetMsgColor()));
    }
    @And("Closes the browser_Login feature")
    public void close_driver () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        soft.assertAll();
    }
}
