package stepDefinition;

import Pages.HomepageWebElements;
import Pages.SearchPageWebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchStepDefinition {

    WebDriver driver = null;
    SoftAssert soft;
    HomepageWebElements homeWE;
    SearchPageWebElements searchWE;

    @Given("the user opens the browser_Search function")
    public void init_browser (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);

        //Object declaration
        driver = new ChromeDriver();
        soft = new SoftAssert();
        homeWE = new HomepageWebElements(driver);
        searchWE = new SearchPageWebElements(driver);
    }
    @And("navigates to the site \"(.*)\"_Search function$")
    public void navigate_to_the_site (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @And("click the search bar")
    public void click_search_bar (){
        homeWE.searchBarWE().click();
    }
    @Then("types \"(.*)\" in the search bar$")
    public void search_for_apple (String keyword) throws InterruptedException {
        Thread.sleep(1000);
        homeWE.searchBarWE().sendKeys(keyword);
    }
    @And("waits till the suggestions appear")
    public void wait_for_suggestions() throws InterruptedException {
        Thread.sleep(2000);
        if (homeWE.suggGridWE().isDisplayed()){
            System.out.println("Suggestions are visible");
        }
        else{
            System.out.println("Suggestions are not visible");
        }
    }
    @And("clicks the search button")
    public void click_search_button (){
        homeWE.searchButtonWE().click();
    }
    @And("Assert that the products match the keyword \"(.*)\"$")
    public void assert_keyword (String keyword){
        System.out.println("The keyword is "+keyword);
        List<WebElement> childrenElements = searchWE.gridWB().findElements(By.cssSelector("div[class=\"product-item\"]"));
        for (WebElement childElement : childrenElements) {
            String attributeValue = childElement.getAttribute("data-productid");
            String itemTitle = childElement.getText();
            soft.assertTrue(itemTitle.contains(keyword),"Item with ID " + attributeValue + "Doesn't have the keyword " + keyword + " in it");
            if (itemTitle.contains(keyword)) {
                System.out.println("Item with ID " + attributeValue + " have the keyword " +keyword+ " in it");
            }
        }
    }
    @And("Assert that the products doesn't contain the keyword \"(.*)\"$")
    public void assert_keyword_does_not_exist(String keyword){
        System.out.println("The keyword is "+keyword);
        List<WebElement> childrenElements = searchWE.gridWB().findElements(By.cssSelector("div[class=\"product-item\"]"));
        for (WebElement childElement : childrenElements) {
            String attributeValue = childElement.getAttribute("data-productid");
            String itemTitle = childElement.getText();
            soft.assertFalse(itemTitle.contains(keyword),"Item with ID " + attributeValue + "Doesn't have the keyword " + keyword + " in it");
            if (!itemTitle.contains(keyword)) {
                System.out.println("Item with ID " + attributeValue + " doesn't have the keyword " +keyword+ " in it");
            }
        }
    }
    @Then("closes the browser_Search function")
    public void close_browser () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }
    @Then("Assert that the suggestions match the keyword \"(.*)\"$")
    public void assert_suggestion (String keyword) {
        System.out.println("The keyword is "+keyword);
        List<WebElement> childrenElements = homeWE.suggGridWE().findElements(By.cssSelector("li[class=\"ui-menu-item\"]"));
        for (WebElement childElement : childrenElements) {
            String itemTitle = childElement.getText();
            soft.assertTrue(itemTitle.contains(keyword));
            if (itemTitle.contains(keyword)) {
                System.out.println("Items match the keyword " +keyword);
            }
        }
    }
}
