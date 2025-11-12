@ui @ab
Feature: A/B Testing

  Scenario: User sees the A/B Test header on the page
    Given I open the AB Testing page
    Then I should see text that contains "A/B Test"