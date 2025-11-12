@ui @dropdown
Feature: Dropdown

  Scenario: User selects "Option 2"
    Given I open the Dropdown page
    When I select "Option 2"
    Then I should see that "Option 2" is selected