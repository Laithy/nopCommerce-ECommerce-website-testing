package stepDefinition;

import Pages.HomepageWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class WishlistStepDefinition {
    WebDriver driver = null;
    SoftAssert soft;
    HomepageWebElements homeWE;
    @Given("the user opens the browser_Wishlist feature")
    public void init_browser (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);

        driver = new ChromeDriver();
        soft = new SoftAssert();
        homeWE = new HomepageWebElements(driver);
    }
    @And("navigates to the site \"(.*)\"_Wishlist function$")
    public void site_navigation (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @When("the user scrolls down the page until he sees the product \"(.*)\"$")
    public void scroll_down (String product) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", homeWE.productWE(product));
        Thread.sleep(2000);
    }
    @Then("the user clicks on the product \"(.*)\"$")
    public void clicks_the_product (String product){
        homeWE.productWE(product).click();
    }
    @And("clicks on add to wishlist")
    public void clicks_on_add_Wishlist (){

    }
    @Then("the user clicks on the button X on the notification")
    public void clicks_on_x (){

    }
    @And("goes to the wishlist page")
    public void go_to_wishlist (){

    }
    @Then("closes the browser_Wishlist function")
    public void close_browser () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }
}
