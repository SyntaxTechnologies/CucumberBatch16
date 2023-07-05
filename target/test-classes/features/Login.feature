Feature: Login related scenarios

  Background:
    #Given user is navigated to HRMS application

  @sprint1 @regression @smoke @newTestcase @newFeature @sprint2 @login1
  Scenario: Valid admin login
    #dont add anything in the step after creating step def
    #Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @employee  @sprint1 @login
  Scenario: valid ess login
    #Given user is navigated to HRMS application
    When user enters ess username and password
    And user clicks on login button
    Then user is successfully logged in the application

  @invalid  @sprint1
  Scenario: invalid admin login
    #Given user is navigated to HRMS application
    When user enters invalid admin username and password
    And user clicks on login button
    Then error message is displayed

  @negative
  Scenario Outline: negative login test
    When user enters "<username>" and "<password>" and verifying the "<error>" for the combinations
    Examples:
      | username | password | error |
      |admin     |fkfkkkj   |Invalid credentials|
      |admin1    |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|







