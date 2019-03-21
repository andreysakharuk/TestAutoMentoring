Feature: Filter models on Ratings page

  Background:
    Given Logged out user opens Ratings page
    And User log in with valid credentials

  Scenario Outline: Logged in user filters models on Ratings Full page
    Then CTA banner isn't displayed on Ratings Full page
    And User clicks Recommended Toggle
    Then Recommended models are displayed in Ratings chart
    And User clicks Clear All button
    Then All 12 models are displayed in Ratings chart
    And Do Price Filtering with <price>
    Then Model's prices are less than <price>
    And Do Rated Best Filtering with <attribute>
    Then Rated Best button becomes green
    And Do More Filtering with <brand>
    Then All models are proper <brand> in Ratings chart

    Examples:
      | price | brand   | attribute |
      | 100   | Eureka  | 0         |
      | 90    | Bissell | 1         |

  Scenario: Logged in user filters price with slider
    And User clicks Price Filter button
    Then Default price is changed after moving slider










