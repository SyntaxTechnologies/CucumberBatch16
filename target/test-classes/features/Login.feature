Feature: Login related scenarios
  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

