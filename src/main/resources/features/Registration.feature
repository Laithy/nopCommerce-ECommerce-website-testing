@Regression
Feature: User should be able to make a new account on the site

  Scenario: User registers with valid data
    Given User opens the browser_Registration feature
    Given User navigates to the website "https://demo.nopcommerce.com/" Registration feature
    And Clicks on register button from the homepage
    When User selects the gender
    And enters first name "Mahmoud"
    And enters last name "Elaithy"
    And enters date of birth "22" "February" "1998"
    And enters a valid email "byruhyda@closetab.email"
    And enters a password "12345678"
    And enters the same password again "12345678"
    And click register
    Then User should see a success message "Your registration completed"
    And the color should be green hex code= "4cb17c"
    And Closes the browser_Registration feature