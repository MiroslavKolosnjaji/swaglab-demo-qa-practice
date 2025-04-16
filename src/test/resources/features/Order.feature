Feature: Login

  Scenario Outline: Successful login with valid credentials
    When User opens URL "https://www.saucedemo.com/"
    And User enters email as <email> and password as <password>
    And Click on Login
    Then Page title should be "Products"
    When User click on burger menu
    And User click on Logout link
    Then Page title should be "Swag Labs"

    Examples:
      | email                   | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

