Feature: Select Price Option

  Scenario: Select price option
    Given I am on the "price option" page
    And I enter vehicle data
    And I enter insurant data
    And I enter product data
    When I select a price option
    Then I should be able to proceed to the next page
