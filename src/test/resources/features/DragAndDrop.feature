@ui @elements
Feature: Drag and drop elements

  Scenario: Drag and drop elements
    Given I open the Drag and Drop page
    When I perform drag and drop from column A to column B
    Then column A should contain "B" and column B should contain "A"