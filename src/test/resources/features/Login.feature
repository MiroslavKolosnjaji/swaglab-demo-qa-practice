@smoke @login
Feature: Login functionality for SwagLabs users


  @positive @standard
  Scenario Outline: Successful login with standard user
    Given user is on the login page
    When  user enters username <user> and password <password>
    And clicks the login button
    Then user should be redirected to the product page

    Examples:
      | user          | password     |
      | standard_user | secret_sauce |


  @negative @locked
  Scenario Outline: Unsuccessful login with locked out user
    Given user is on the login page
    When user enters username <user> and password <password>
    And clicks the login button
    Then user should expect message <message>

    Examples:
      | user            | password       | message                                                                   |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |
      | user_123        | doesn't exists | Epic sadface: Username and password do not match any user in this service |