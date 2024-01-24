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
    public WebElement regWE (){
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
    public WebElement loginWE (){
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }
    public WebElement searchButtonWE () {
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }
    public WebElement searchBarWE () {
        return driver.findElement(By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"]"));
    }
    public WebElement suggGridWE () {
        return driver.findElement(By.cssSelector("ul[id=\"ui-id-1\"]"));
    }

}
