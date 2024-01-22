Feature: User should be able to make a new account on the site

  Scenario: User registers with valid data
    Given User navigates to the website "https://demo.nopcommerce.com/"
    And Clicks on register button from the homepage
    When User selects the gender
    And enters first name
    And enters last name
    And enters date of birth
    And enters a valid email
    And enters a password
    And enters the same password again
    Then User should see a success message "Your registration completed"
    And the color should be green hex code= "4cb17c"