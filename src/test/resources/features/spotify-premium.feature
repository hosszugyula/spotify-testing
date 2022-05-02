Feature: Spotify premium page

  Background:
    Given the home page is opened
    #And the Cookie disclaimer is closed
    And the Premium header button is clicked

  Scenario:
    When the get started under "Individual" plan is clicked
    Then the page is navigated to authentication continuing to "Individual" plan url

  Scenario:
    When the get started under "Duo" plan is clicked
    Then the page is navigated to authentication continuing to "Duo" plan url

  Scenario:
    When the get started under "Family" plan is clicked
    Then the page is navigated to authentication continuing to "Family" plan url

  Scenario:
    When the get started under "Student" plan is clicked
    Then the page is navigated to authentication continuing to "Student" plan url

  Scenario:
    When the get 3 months free button is clicked
    Then the page is navigated to authentication continuing to "Individual" plan url

  Scenario:
    When the view plans button is clicked
    Then the premium page is scrolled to the plans