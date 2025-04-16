Feature: Ordering

 Scenario Outline : Verify that valid user can successfully order available products
    Given generate valid user
    When login as valid user with <username> and <password>
    Then verify that user landed on the products page
    And user add desired products to the Cart
    Then verify that shopping cart contains notification with correct number
    And checkout from the Cart
    And populate the form on the Your Information page with first name <firstName>, last name <lastName>, and postal code <postalCode>
    And finish the order
    Then should receive the success message

   Examples:
     | username      | password     | firstName | lastName | postalCode |
     | standard_user | secret_sauce | John      | Smith    | 24352      |


