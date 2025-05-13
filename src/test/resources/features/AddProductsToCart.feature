@smoke @cart
Feature: Add products to cart functionality

  Scenario Outline: Successfully add products to cart
    Given user is on the login page
    When user enters username <user> and password <password>
    And clicks the login button
    Then user should be redirected to the product page
    When user add desired products to the Cart
    Then verify that shopping cart contains notification with correct number

    Examples:

      | user          | password     |
      | standard_user | secret_sauce |