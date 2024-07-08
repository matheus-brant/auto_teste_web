Feature: Happy Path

  Scenario: Enter vehicle data
    Given I am on the "vehicle data" page
    When I enter vehicle data
    Then I should be able to proceed to the next page

  Scenario: Enter insurant data
    Given I am on the "insurant data" page
    When I enter insurant data
    Then I should be able to proceed to the next page

  Scenario: Enter product data
    Given I am on the "product data" page
    When I enter product data
    Then I should be able to proceed to the next page

  Scenario: Select price option
    Given I am on the "price option" page
    When I select a price option
    Then I should be able to proceed to the next page

  Scenario: Enter quote data
    Given I am on the "send quote" page
    When I enter quote data
    Then The quote should be sent

  @last
  Scenario: Complete Happy Path
    Given I am on the "vehicle data" page
    When I complete the happy path
    Then The quote should be sent
