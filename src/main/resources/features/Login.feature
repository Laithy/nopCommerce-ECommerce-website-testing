Feature: User should be able to login with registered account

  Background:
    Given User opens the browser_Login feature
    Given User navigates to the website "https://demo.nopcommerce.com/" LoginFeature
    And click on the login button

  Scenario: User use valid credentials
    When Login with email "tafif42887@trackden.com"
    And Login with password "12345678"
    Then Click on log in
    And Closes the browser_Login feature

  Scenario: User use invalid credentials
    When Login with email "tafif428@trackden.com"
    And Login with password "123456789"
    Then Click on log in
