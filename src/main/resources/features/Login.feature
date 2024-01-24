@Regression
Feature: User should be able to login with registered account

  Background:
    Given User opens the browser_Login feature
    Given User navigates to the website "https://demo.nopcommerce.com/" LoginFeature
    And click on the login button

  Scenario: User use valid credentials
    When Login with email "byruhyda@closetab.email"
    And Login with password "12345678"
    Then Click on log in
    And assert positive scenario
    And Closes the browser_Login feature

  Scenario: User use invalid credentials
    When Login with email "zyqe@imagepoet.net"
    And Login with password "123456789"
    Then Click on log in
    And assert negative scenario "Login was unsuccessful" "#e4434b"
    And Closes the browser_Login feature
