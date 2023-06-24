Feature: Adding employee in HRMS application

  @test
  Scenario: adding one employee
    * user enters valid admin username and password
    * user clicks on login button
    * user is successfully logged in the application
    * user clicks on PIM option
    * user clicks on add employee button
    * user enters firstname and lastname
    * user clicks on save button
    * employee added successfully
