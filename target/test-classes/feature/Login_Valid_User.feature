#Author: abhimanyu.athikayan@gmail.com
Feature: Login Success

  @positive @all @login
  Scenario Outline: TC1 - Successful Login to application
    Given User Navigates to 'AutomationPractice' website URL
    Then User clicks on SignIn button in Home page
    When User provides credentials for "<Username>" and "<Password>"
    Then User clicks on SignIn button in Login page
    And Verify user is loggedIn as "<FULLNAME>"

    Examples: 
      | Username                    | Password | FULLNAME |
      | hf_test_44556677@hf4567.com | qwerty   | Dean Joe |
