Feature: Ordering

  @end2end
  Scenario: Verify that valid user can successfully order available products
    Given generate valid user
    When login as valid user
    Then verify that user landed on the products page
    And user add desired products to the Cart
    Then verify that shopping cart contains notification with correct number
    And checkout from the Cart
    And populate the form on the Your Information page
    And finish the order
    Then should receive the success message




