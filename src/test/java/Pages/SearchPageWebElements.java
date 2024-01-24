package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageWebElements {
    WebDriver driver;
    //Constructor
    public SearchPageWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement itemsWB (){
        return driver.findElement(By.cssSelector("div[class=\"product-item\"]"));
    }
    public WebElement gridWB (){
        return driver.findElement(By.cssSelector("div[class=\"item-grid\"]"));
    }
}
