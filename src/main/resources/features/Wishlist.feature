Feature: User should be able to add an item to the wishlist

  Scenario: User scrolls down to a product and add it to his wishlist then goes to his wishlist page
    Given the user opens the browser_Wishlist feature
    And navigates to the site "https://demo.nopcommerce.com/"_Wishlist function
    When the user scrolls down the page until he sees the product "HTC One M8 Android L 5.0 Lollipop"
    Then the user clicks on the product "HTC One M8 Android L 5.0 Lollipop"
#    And clicks on add to wishlist
#    Then the user clicks on the button X on the notification
#    And goes to the wishlist page
    Then closes the browser_Wishlist function