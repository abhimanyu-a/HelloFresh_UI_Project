# HelloFresh_UI_Project
The purpose of this project is to design a comprehensive UI framework to perform UI functional automation testing
Project Summary:

# Overview
The UI automation framework is developed with the help of **Selenium Webdriver** with **POM** modal and ``` Webdriver factory ``` as the automation  engine and Cucumber BDD framework acting as a wrapper around the test layer. 

All page elements and its related functions are stored in ``` src/main/java ``` under the package com.hellofresh.pages
The test utils like screenshot taker, loggers and driver managers are stored in ``` src/main/utils ```
``` config.properties ``` contains all the configuration settings
``` com.hellofresh.testRunner ``` package contains the ```CucumberRunnerTest.class``` class to initiate the tests
``` com.hellofresh.stepDefinition ``` package contains the ``` StepDefinition.java ``` class that contains the test steps
The test resources like feature file, config.property file are placed in the ``` src/test/resources ```

The page classes are listening to a base class which provides a fluent API interface to access the test method. Hence, using the '.' operator, subsequent actions can be added with ease.
Tests are written in Gherkin language in feature file following BDD style
Test data are stored in feature file as well as config file. As a resullt, the feature file is the single point of resource for understanding a feature.
Parallel execution, running in incognito and headless mode are the other features that can be changed from the  ``` Config.properties  ``` file placed in  ``` src/test/resources  ```

- **Test1** -->  Login_Valid_User.feature
- **Test2:**--> User_Signup.feature
- **Test3:**--> Checkout_Sucessful.feature
- **Test4:** Login_Invalid_Credentials.feature

#### Steps to run
### Method1
**From Eclipse Editor**
Goto src/test/java > com.hellofresh.testRunner
Right click on "CucumberRunnerTest.java" > Run As > JUnit Test

### Method2
**From Maven**
Go to the root folder of the repository.
Open Power shell or CMD
type the following command
``` 
    mvn install 
    mvn test 
```
## Reports

## Logs

<img width="956" alt="Log" src="https://user-images.githubusercontent.com/54126870/76310617-1fe78e80-62f5-11ea-9a9f-fd5c6ffeb92b.PNG">

## Headless mode

<img width="960" alt="Headless" src="https://user-images.githubusercontent.com/54126870/76310820-908eab00-62f5-11ea-9cf2-642b01829072.PNG">


