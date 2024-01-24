package stepDefinition;

import Pages.HomepageWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SearchStepDefinition {

    WebDriver driver = null;
    SoftAssert soft;
    HomepageWebElements homeWE;

    @Given("the user opens the browser_Search function")
    public void init_browser (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);

        //Object declaration
        driver = new ChromeDriver();
        soft = new SoftAssert();
        homeWE = new HomepageWebElements(driver);
    }
    @And("navigates to the site \"(.*)\"_Search function$")
    public void navigate_to_the_site (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Then("types \"(.*)\" in the search bar$")
    public void search_for_apple (String keyword) throws InterruptedException {
        Thread.sleep(2000);
        homeWE.searchBarWE().sendKeys(keyword);
    }
    @And("clicks the search button")
    public void click_search_button (){
        homeWE.searchButtonWE().click();
    }
    @And("Assert that the products match the keyword \"(.*)\"$")
    public void assert_keyword (String keyword){

    }
    @And("Assert that the products doesn't contain the keyword \"(.*)\"$")
    public void assert_keyword_does_not_exist(String keyword){

    }
    @Then("closes the browser_Search function")
    public void close_browser () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        soft.assertAll();
    }

}
