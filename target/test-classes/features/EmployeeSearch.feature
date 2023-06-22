Feature: Search an employee

  Scenario: Search employee by id
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option and Employee list option
    And user enters valid employee id
    And user clicks on search button
    Then user is able to see employee information

  Scenario: Search employee by name
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option and Employee list option
    And user enters valid employee name in name text box
    And user clicks on search button
    Then user is able to see employee information
