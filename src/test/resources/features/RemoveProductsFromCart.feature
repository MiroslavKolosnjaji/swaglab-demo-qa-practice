@smoke @cart
Feature: Remove products from the cart functionality

  Scenario Outline: Successfully remove products from the cart
    Given user is on the login page
    When user enters username <user> and password <password>
    And clicks the login button
    Then user should be redirected to the product page
    And user add desired products to the Cart
    Then verify that shopping cart contains notification with correct number
    And user remove desired products from the cart
    Then verify that shopping cart contains notification with correct number <postRemovalQuantity>

    Examples:
      | user          | password     |  | postRemovalQuantity |
      | standard_user | secret_sauce |  | 4                   |
