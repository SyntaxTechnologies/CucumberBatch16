Feature: Adding employee in HRMS application

  @test
  Scenario: adding one employee
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application
    When user clicks on PIM option
    And user clicks on add employee button
    When user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully
