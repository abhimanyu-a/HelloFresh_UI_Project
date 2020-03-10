#Author: abhimanyu.athikayan@gmail.com
Feature: Successful registration

  @all @positive
  Scenario: TC2 - Successful registartion of new user to application
    Given User Navigates to 'AutomationPractice' website URL
    Then User clicks on SignIn button in Home page
    When User provides valid emailId for account creation
    Then User clicks on Create An Account button
    And Verify user is present on Registartion page
    When User fills Registration form with valid details
      | gender | firstname | lastname | password | day | month | year | company    | addressline1 | addressline2 | city     | state    | zipcode | addninfo | homephone  | mobphone   | alias |
      | female | Jean      | Doe      | qwerty   |  12 |    11 | 1991 | HelloFresh | add line1    | add line2    | New York | Colorado |   12345 | info     | 9876543212 | 4567890987 | alis  |
    Then Verify user was created successfully
    And User name and logout button was displayed correctly
