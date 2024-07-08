Feature: Fill vehicle data
  Scenario: Filling the form with valid data
    Given the user is on the tricentis vehicle data page
    When the user enters vehicle data "Audi" "Scooter" "1000" "500" "01/01/2020" "4" "2" "Diesel" "1000" "3000" "50000" "15000"
    And the user clicks next on vehicle data page
    When the user enters insurant data "John" "Doe" "01/01/1990" "Brazil" "12345" "Employee" "Bungee Jumping"
    And the user clicks next on insurant data page
    When the user enters product data "01/01/2025" "30000000" "Bonus 1" "Full Coverage" "Euro Protection" "Yes"
    And the user clicks next on product data page
    When the user selects a price option
    And the user clicks next on price option page
    When the user enters quote data "john.doe@example.com" "1234567890" "john_doe" "@3eR&90" "@3eR&90"
    And the user clicks send
    Then the user should see the success message
