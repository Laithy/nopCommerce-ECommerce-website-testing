package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageWebElements {
    WebDriver driver;
    //Constructor
    public HomepageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }

    //Locators
    private WebElement regWE (){
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
    private WebElement loginWE (){
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }
    private WebElement searchButtonWE () {
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }
    private WebElement searchBarWE () {
        return driver.findElement(By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"]"));
    }
    private WebElement suggGridWE () {
        return driver.findElement(By.cssSelector("ul[id=\"ui-id-1\"]"));
    }
    private WebElement productWE (String productName) {return driver.findElement(By.partialLinkText(productName));}
    private WebElement itemGridWE () {
        return driver.findElement(By.cssSelector("div[class=\"product-grid home-page-product-grid\"]>div[class=\"item-grid\"]"));
    }

    //Actions
    public void ClickRegisterButton () {
        regWE().click();
    }
    public void ClickLoginButton () {
        loginWE().click();
    }

}
