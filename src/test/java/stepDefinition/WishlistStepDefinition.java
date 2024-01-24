package stepDefinition;

import Pages.HomepageWebElements;
import Pages.ProductWebElements;
import Pages.WishlistWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WishlistStepDefinition {
    WebDriver driver = null;
    SoftAssert soft;
    HomepageWebElements homeWE;
    ProductWebElements prodWE;
    WishlistWebElements wishWE;
    @Given("the user opens the browser_Wishlist feature")
    public void init_browser (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);

        driver = new ChromeDriver();
        soft = new SoftAssert();
        homeWE = new HomepageWebElements(driver);
        prodWE = new ProductWebElements(driver);
        wishWE = new WishlistWebElements(driver);
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
    public void clicks_the_product (String product) throws InterruptedException {
        homeWE.productWE(product).click();
        Thread.sleep(1000);
    }
    @And("clicks on add to wishlist \"(.*)\" \"(.*)\"$")
    public void clicks_on_add_Wishlist (String successMSG,String expectedHex) throws InterruptedException {
        prodWE.addWishlistWE().click();
        Thread.sleep(2000);

        String displayedMSG = prodWE.notifBar().getText();
        String color = prodWE.notifBar().getCssValue("background-color");
        String actualHex = Color.fromString(color).asHex();

        soft.assertTrue(prodWE.notifBar().isDisplayed(),"The notification bar isn't displayed");
        soft.assertTrue(displayedMSG.contains(successMSG),"The notification bar doesn't have the expected message");
        soft.assertTrue(expectedHex.contains(actualHex),"The color of the notification bar is wrong");
        System.out.println(actualHex);
    }
    @Then("the user clicks on the button X on the notification")
    public void clicks_on_x () {
        if (prodWE.closeNotifButtonWE().isDisplayed()){
            prodWE.closeNotifButtonWE().click();
        }
        Assert.assertTrue(prodWE.wishlistQTYWE().getText().contains("1"));
    }
    @And("goes to the wishlist page \"(.*)\"$")
    public void go_to_wishlist (String product) throws InterruptedException {
        prodWE.wishlistButtonWE().click();
        Thread.sleep(2000);
        soft.assertTrue(wishWE.productNameWE().getText().contains(product),"The wishlist got the wrong item");
    }
    @Then("closes the browser_Wishlist function")
    public void close_browser () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }
}
