package stepDefinition;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CartStepDefinition {
    WebDriver driver = null;
    SoftAssert soft;
    HomepageWebElements homeWE;
    ProductWebElements prodWE;
    CartWebElements cartWE;
    CheckoutLoginWebElements checkWE;
    CheckoutBillingWebElements billingWE;
    CheckoutShippingMethodWebElements shippingWE;
    CheckoutPaymentMethodWebElements paymentWE;
    CheckoutPaymentInformationWebElements paymentInfoWE;
    CheckoutConfirmOrderWebElements confirmWE;
    Actions action;
    @Given("the user opens the browser_Cart function")
    public void init_browser (){
        //Creating Driver
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver",chromePath);

        driver = new ChromeDriver();
        soft = new SoftAssert();
        homeWE = new HomepageWebElements(driver);
        prodWE = new ProductWebElements(driver);
        cartWE = new CartWebElements(driver);
        checkWE = new CheckoutLoginWebElements(driver);
        billingWE = new CheckoutBillingWebElements(driver);
        shippingWE = new CheckoutShippingMethodWebElements(driver);
        paymentWE = new CheckoutPaymentMethodWebElements(driver);
        paymentInfoWE = new CheckoutPaymentInformationWebElements(driver);
        confirmWE = new CheckoutConfirmOrderWebElements(driver);
        action = new Actions(driver);

    }
    @And("navigates to the site \"(.*)\"_Cart function$")
    public void site_navigation (String Website) throws InterruptedException {
        driver.navigate().to(Website);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @When("user scrolls down the page until he sees the product \"(.*)\"_Cart Feature$")
    public void scroll_down (String product) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", homeWE.productWE(product));
        Thread.sleep(2000);
    }
    @And("click on add to cart button from the homepage \"(.*)\"$")
    public void click_add_to_cart_homepage (String productTitle) {
        List <WebElement> childrenElements = homeWE.itemGridWE().findElements(By.cssSelector("div[class=\"item-box\"]"));
        for (WebElement childElement : childrenElements) {
            String itemTitle = childElement.getText();
            if (itemTitle.contains(productTitle)) {
                WebElement productAddToCart = childElement.findElement(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]"));
                productAddToCart.click();
            }
        }
    }
    @And("click on add to cart button from the product details page")
    public void click_add_to_cart_product_page () throws InterruptedException {
        Thread.sleep(2000);
        prodWE.addToCartButtonWE().click();
    }
    @And("click on x button on the notification bar")
    public void click_on_x() throws InterruptedException {
        Thread.sleep(2000);
        if (prodWE.notifBar().isDisplayed()){
            prodWE.closeNotifButtonWE().click();
        }
    }
    @Then("hover over the shopping cart")
    public void hover_over_shoppingCartButton () throws InterruptedException {
        action.moveToElement(prodWE.shoppingCartButtonWE()).perform();
        Thread.sleep(1000);
    }
    @And("click on go to cart")
    public void click_on_goToCart () {
        prodWE.flyOutCartWE("Go to cart").click();
    }
    @Then("check the mark on i agree with the terms")
    public void check_the_terms () throws InterruptedException {
        Thread.sleep(1000);
        cartWE.termsCheckboxWE().click();
        Thread.sleep(1000);
    }
    @And("click on checkout button")
    public void click_checkout () {
     cartWE.checkoutButtonWE().click();
    }
    @And("click on check out as a guest")
    public void checkout_guest () throws InterruptedException {
        Thread.sleep(1000);
        checkWE.checkoutGuestWE().click();
        Thread.sleep(1000);
    }
    @Then("fill all valid data in the billing address section \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void fill_billing (String firstName,String lastName,String email,String country,String city,String address,String postalCode,String phoneNumber) {
        billingWE.firstNameWE().sendKeys(firstName);
        billingWE.lastNameWE().sendKeys(lastName);
        billingWE.emailWE().sendKeys(email);
        Select drpCountry = new Select(billingWE.countryWE());
        drpCountry.selectByVisibleText(country);
        billingWE.cityWE().sendKeys(city);
        billingWE.addressWE().sendKeys(address);
        billingWE.postalCodeWE().sendKeys(postalCode);
        billingWE.phoneNumberWE().sendKeys(phoneNumber);
    }
    @And("click continue button_billing")
    public void click_continue_billing () {
        billingWE.continueButtonWE().click();
    }
    @And("fill all valid data in the shipping address section")
    public void fill_shippingMethod () throws InterruptedException {
        Thread.sleep(1000);
        shippingWE.nextDayCheckboxWE().click();
    }
    @And("click continue button_shippingMethode")
    public void click_continue_shipping () {
        shippingWE.continueButtonWE().click();
    }
    @And("select payment method")
    public void select_payment_method () throws InterruptedException {
        Thread.sleep(1000);
        paymentWE.creditCardWE().click();
    }
    @And("click continue button_Payment")
    public void click_continue_payment () {
        paymentWE.continueButtonWE().click();
    }
    @And("continue payment information \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void fill_payment_info (String creditCard, String cardholderName, String cardNumber, String expMonth, String expYear, String cardCode) throws InterruptedException {
        Thread.sleep(1000);
        Select drpCred = new Select(paymentInfoWE.selectCredWE());
        drpCred.selectByVisibleText(creditCard);
        paymentInfoWE.cardholderWE().sendKeys(cardholderName);
        paymentInfoWE.cardNumberWE().sendKeys(cardNumber);
        Select drpExpMonth = new Select(paymentInfoWE.expMonthWE());
        drpExpMonth.selectByVisibleText(expMonth);
        Select drpExpYear = new Select(paymentInfoWE.expYearWE());
        drpExpYear.selectByVisibleText(expYear);
        paymentInfoWE.cardCodeWE().sendKeys(cardCode);
        Thread.sleep(1000);
    }
    @And("click continue button_Payment information")
    public void click_continue_paymentInfo () {
        paymentInfoWE.continueButtonWE().click();
    }
    @And("click on confirm order")
    public void click_confirm () throws InterruptedException {
        Thread.sleep(1000);
        confirmWE.confirmButtonWE().click();
    }
    @Then("closes the browser_Cart function")
    public void close_browser () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        soft.assertAll();
    }


}
