Feature: Check Ratings functions

  Scenario: Shop button navigates to proper Amazon page
    When Logged out user clicks Upright link in Type section on Overview page
    Then Cta banner appears on Ratings Compact page
    And Logged out user clicks Become a Member link
    Then Cta banner appears on Membership page
    And User clicks Shop button on Ratings Compact page
    Then Price And Shop title appears on Model page
    And User click Amazon button on Model page
    Then Amazon site is opened

  Scenario: Slider scroll works in Ratings chart
    When Logged out user opens Ratings page
    And User log in with valid credentials
    And Move slider in Ratings chart
    Then Specs header appears

  Scenario: Specs header appears in Ratings chart
    When Logged out user opens Ratings page
    And User log in with valid credentials
    And Click CR logo in footer
    Then Account Info section appears on Home page

  Scenario: Adding Models to Compare
    When Logged out User opens Home page
    Then Main Articles section appears on Home page
    And User log in with valid credentials
    Then Account Info section appears on Home page
    And Do Search for Miele Dynamic U1 Cat & Dog
    Then All models are Miele brand and Showing results for Miele Dynamic U1 Cat
    And Click first search result
    Then Title Miele Dynamic U1 Cat & Dog appears on Model page
    And Click Ratings Compact icon
    Then Ratings list is displayed
    And Click Add to Compare button
    Then 1 Model is added to Compare bucket on Ratings Compact page
    And Click Ratings Full icon
    Then Ratings full view is displayed
    And Click Add to Compare button on Ratings Full page
    Then 2 Model is added to Compare bucket on Ratings Full page
    And Click View button in Compare bucket
    Then Model Kenmore Elite Pet Friendly 31150 is on 0 position on Compare page
    Then Model Shark Navigator Powered Lift-Away NV586 (Target) is on 1 position on Compare page
    And Click Remove buttons
    Then Error appears on Empty Compare page

