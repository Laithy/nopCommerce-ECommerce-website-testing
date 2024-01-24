Feature: User should be able to search for items and see reasonable suggestions

  Scenario: User types Apple in the search bar and should see only apple products and then type card and only see product with the keyword card in them and not apple
    Given the user opens the browser_Search function
    And navigates to the site "https://demo.nopcommerce.com/"_Search function
    Then types "Apple" in the search bar
    And clicks the search button
    And Assert that the products match the keyword "Apple"
    Then types "Card" in the search bar
    And clicks the search button
    And Assert that the products match the keyword "Card"
    And Assert that the products doesn't contain the keyword "Apple"
    Then closes the browser_Search function

  Scenario: User types Apple in the search bar he should see suggestions match the searched word