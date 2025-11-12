@ui @checkbox
Feature: Checkbox

  Scenario: Select all checkboxes and check that they are selected
    Given I open the Checkboxes page
    When I select all checkboxes
    Then all checkboxes should be selected