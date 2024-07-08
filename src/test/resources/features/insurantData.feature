Feature: Insurant Data

  Scenario: Enter invalid first name
    Given I am on the "insurant data" page
    And I enter vehicle data
    When I enter invalid first name "A"
    Then An error message should be displayed for first name

  Scenario: Enter invalid first name
    Given I am on the "insurant data" page
    And I enter vehicle data
    When I enter invalid first name "ThisNameIsWayTooLongToBeValidAndShouldFail"
    Then An error message should be displayed for first name

  Scenario: Enter valid insurant data
    Given I am on the "insurant data" page
    And I enter vehicle data
    When I enter insurant data
    Then I should be able to proceed to the next page
