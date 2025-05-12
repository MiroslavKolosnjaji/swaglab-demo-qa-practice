@smoke @logout
Feature: Logout functionality

  Scenario Outline: Successful logout
    Given user is on the login page
    When user enters username <user> and password <password>
    And clicks the login button
    Then user should be redirected to the product page
    When user open hamburger menu
    And clicks the Logout link
    Then user should be redirected to the login page

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |