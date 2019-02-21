Feature: Check applying Filters on Ratings page


  Scenario: Change value in Price filter with scroll bar
    Given i opened Ratings page
    And i login
    When i click Price filter
    And i drag scroll bar
    Then Default price is changed