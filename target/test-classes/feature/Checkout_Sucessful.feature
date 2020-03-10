Feature: Sucessful Checkout

   @all @positive
  Scenario Outline: TC3 - Successful checkout with valid user
    Given User Navigates to 'AutomationPractice' website URL
    Then User clicks on SignIn button in Home page
    When User provides credentials for "<Username>" and "<Password>"
    Then User clicks on SignIn button in Login page
    And Verify user is loggedIn as "<FULLNAME>"
    When User clicks on 'Women' section link
    And User selects a product and adds it to cart
      | productname                 | quantity | size | color |
      | Faded Short Sleeve T-shirts |        3 | M    | Blue  |
    Then Verify product has been added to cart
    And Verify cart product details and proceed
    When User clicks on Proceed to checkout
    Then Verify address and proceed
    And Verify shipping and proceed
    When User selects 'Bankwire' payment method
    And User confirms the order
    Then Verify order completion details

    Examples: 
      | Username                    | Password | FULLNAME |
      | hf_test_44556677@hf4567.com | qwerty   | Dean Joe |
