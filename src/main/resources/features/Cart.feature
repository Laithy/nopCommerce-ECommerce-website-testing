Feature: User should be able to add an item to a cart and checkout
  Scenario: User add an item to a cart and checkout
    Given the user opens the browser_Cart function
    And navigates to the site "https://demo.nopcommerce.com/"_Cart function
    When user scrolls down the page until he sees the product "Apple MacBook Pro 13-inch"_Cart Feature
    And click on add to cart button from the homepage "Apple MacBook Pro 13-inch"
    And click on add to cart button from the product details page
    And click on x button on the notification bar
    Then hover over the shopping cart
    And click on go to cart
    Then check the mark on i agree with the terms
    And click on checkout button
    And click on check out as a guest
    Then fill all valid data in the billing address section "Mahmoud" "El-laithy" "byruhyda@closetab.email" "Egypt" "Mansoura" "Hay ElGamaa" "55555" "01111111111"
    And click continue button_billing
    And fill all valid data in the shipping address section
    And click continue button_shippingMethode
    And select payment method
    And click continue button_Payment
    And continue payment information "Visa" "Jane Doe" "4001919257537193" "09" "2026" "837"
    And click continue button_Payment information
    And click on confirm order
#    Then closes the browser_Cart function