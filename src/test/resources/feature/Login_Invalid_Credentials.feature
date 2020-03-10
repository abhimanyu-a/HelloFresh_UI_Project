Feature: Invalid Login

  @positive @all @login
  Scenario Outline: TC1 - Login with incorrect credentials
    Given User Navigates to 'AutomationPractice' website URL
    Then User clicks on SignIn button in Home page
    When User provides credentials for "<Username>" and "<Password>"
    Then User clicks on SignIn button in Login page
    And Verify user is shown an error message"

    Examples: 
      | Username                    | Password    | FULLNAME |
      | hf_test_44556677@hf4567.com | qwertqwerty | Dean Joe |
