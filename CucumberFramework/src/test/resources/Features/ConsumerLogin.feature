Feature: Comsumer Login Functionality

  Background: Given user is already on Login Page

  Scenario Outline: Successful login with valid username and password
    When user enters "<username>" and "<password>"
    Then user should be redirected to the Consumer dashboard
    Then user logout from the application

  Scenario Outline: Unsuccessful login with valid username and invalid password
    When user enters "<username>" and "<password>"
    Then an error message Invalid Password is displayed
    And user is still on the Login Page

  Scenario Outline: Unsuccessful login with invalid username
    When user enters "<username>" and "<password>"
    Then an error message Invalid Email/Mobile Number is displayed
    And user is still on the Login Page

    Examples: 
      | username                         | password   |
      | chakravarthigattupelly@gmail.com | Chakri@932 |
      | chakravarthigattupelly@gmail.com | Plural@12  |
      | chakravarthi@gmail.com           | Chakri@932 |
