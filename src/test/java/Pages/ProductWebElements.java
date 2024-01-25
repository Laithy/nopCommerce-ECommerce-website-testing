package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductWebElements {
    WebDriver driver;
    //Constructor
    public ProductWebElements (WebDriver mainDriver){
        this.driver = mainDriver;
    }
    public WebElement addWishlistWE () {
        return driver.findElement(By.cssSelector("button[id=\"add-to-wishlist-button-18\"]"));
    }
    public WebElement notifBar () {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement closeNotifButtonWE (){
        return driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }
    public WebElement wishlistButtonWE (){
        return driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }
    public WebElement wishlistQTYWE () {
        return driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]"));
    }
    public WebElement addToCartButtonWE () {
        return driver.findElement(By.cssSelector("div[class=\"add-to-cart-panel\"]>button[type=\"button\"]"));
    }
    public WebElement shoppingCartButtonWE () {
        return driver.findElement(By.cssSelector("li[id=\"topcartlink\"]>a[href=\"/cart\"]"));
    }
    public WebElement flyOutCartWE (String title) {
        return driver.findElement(By.cssSelector("div[id=\"flyout-cart\"]>div[class=\"mini-shopping-cart\"]>div[class=\"buttons\"]")).findElement(By.cssSelector("button[onclick=\"setLocation('/cart')\"]"));
    }
}
