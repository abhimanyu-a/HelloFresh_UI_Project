$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/Checkout_Sucessful.feature");
formatter.feature({
  "name": "Sucessful Checkout",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "TC3 - Successful checkout with valid user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@m1u1"
    },
    {
      "name": "@all"
    },
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.step({
  "name": "User provides credentials for \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify user is loggedIn as \"\u003cFULLNAME\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on \u0027Women\u0027 section link",
  "keyword": "When "
});
formatter.step({
  "name": "User selects a product and adds it to cart",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "productname",
        "quantity",
        "size",
        "color"
      ]
    },
    {
      "cells": [
        "Faded Short Sleeve T-shirts",
        "3",
        "M",
        "Blue"
      ]
    }
  ]
});
formatter.step({
  "name": "Verify product has been added to cart",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify cart product details and proceed",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on Proceed to checkout",
  "keyword": "When "
});
formatter.step({
  "name": "Verify address and proceed",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify shipping and proceed",
  "keyword": "And "
});
formatter.step({
  "name": "User selects \u0027Bankwire\u0027 payment method",
  "keyword": "When "
});
formatter.step({
  "name": "User confirms the order",
  "keyword": "And "
});
formatter.step({
  "name": "Verify order completion details",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "FULLNAME"
      ]
    },
    {
      "cells": [
        "hf_test_44556677@hf4567.com",
        "qwerty",
        "Dean Joe"
      ]
    }
  ]
});
formatter.scenario({
  "name": "TC3 - Successful checkout with valid user",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@m1u1"
    },
    {
      "name": "@all"
    },
    {
      "name": "@positive"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_Navigates_to_website(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides credentials for \"hf_test_44556677@hf4567.com\" and \"qwerty\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_provides_valid_credentials_for_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify user is loggedIn as \"Dean Joe\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_user_is_loggedIn_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on \u0027Women\u0027 section link",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_section_link(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects a product and adds it to cart",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_selects_a_product_and_adds_it_to_cart(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify product has been added to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_product_has_been_added_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify cart product details and proceed",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_cart_product_details_and_proceed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Proceed to checkout",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify address and proceed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_address_and_proceed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify shipping and proceed",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_shipping_and_proceed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects \u0027Bankwire\u0027 payment method",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_selects_payment_method(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User confirms the order",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_confirms_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify order completion details",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_order_completion_details()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/feature/Login_Invalid_Credentials.feature");
formatter.feature({
  "name": "Invalid Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "TC1 - Login with incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@all"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.step({
  "name": "User provides credentials for \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify user is shown an error message\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "FULLNAME"
      ]
    },
    {
      "cells": [
        "hf_test_44556677@hf4567.com",
        "qwertqwerty",
        "Dean Joe"
      ]
    }
  ]
});
formatter.scenario({
  "name": "TC1 - Login with incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@all"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_Navigates_to_website(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides credentials for \"hf_test_44556677@hf4567.com\" and \"qwertqwerty\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_provides_valid_credentials_for_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify user is shown an error message\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_user_is_shown_an_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/feature/Login_Valid_User.feature");
formatter.feature({
  "name": "Login Success",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "TC1 - Successful Login to application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@all"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.step({
  "name": "User provides credentials for \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.step({
  "name": "Verify user is loggedIn as \"\u003cFULLNAME\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "FULLNAME"
      ]
    },
    {
      "cells": [
        "hf_test_44556677@hf4567.com",
        "qwerty",
        "Dean Joe"
      ]
    }
  ]
});
formatter.scenario({
  "name": "TC1 - Successful Login to application",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    },
    {
      "name": "@all"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_Navigates_to_website(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides credentials for \"hf_test_44556677@hf4567.com\" and \"qwerty\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_provides_valid_credentials_for_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Login page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify user is loggedIn as \"Dean Joe\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_user_is_loggedIn_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/feature/User_Signup.feature");
formatter.feature({
  "name": "Successful registration",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "TC2 - Successful registartion of new user to application",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@all"
    },
    {
      "name": "@positive"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to \u0027AutomationPractice\u0027 website URL",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_Navigates_to_website(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on SignIn button in Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_sign_in_button_from_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides valid emailId for account creation",
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_provides_valid_emailId_for_account_creation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Create An Account button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_clicks_on_Create_An_Account_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify user is present on Registartion page",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_user_is_present_on_Registartion_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User fills Registration form with valid details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_fills_Registration_form_with_valid_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: [[ChromeDriver: chrome on WINDOWS (5cb44de3ef96fe3124d3d5767aff5d72)] -\u003e id: id_gender2] (tried for 10 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027INUH101955\u0027, ip: \u0027192.168.43.19\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.132, chrome: {chromedriverVersion: 80.0.3987.106 (f68069574609..., userDataDir: C:\\Users\\NDH00649\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:63740}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 5cb44de3ef96fe3124d3d5767aff5d72\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat com.hellofresh.page.BasePage.waitAndClick(BasePage.java:61)\r\n\tat com.hellofresh.page.RegistrationPage.enterRegistrationDetails(RegistrationPage.java:127)\r\n\tat com.hellofresh.stepDefinition.StepDefinition.user_fills_Registration_form_with_valid_details(StepDefinition.java:153)\r\n\tat ✽.User fills Registration form with valid details(file:///C:/Users/NDH00649/Desktop/MyWorkSpace/hellofresh-UI-project/src/test/resources/feature/User_Signup.feature:11)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify user was created successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.verify_user_was_created_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User name and logout button was displayed correctly",
  "keyword": "And "
});
formatter.match({
  "location": "com.hellofresh.stepDefinition.StepDefinition.user_name_and_logout_button_was_displayed_correctly()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});