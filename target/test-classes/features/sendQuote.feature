Feature: Send Quote

  Scenario: Enter quote data
    Given I am on the "send quote" page
    And I enter vehicle data
    And I enter insurant data
    And I enter product data
    And I select a price option
    When I enter quote data
    Then The quote should be sent
