@tag
Feature: Login Functionality

@tag1
Scenario Outline: Successful login with valid username and password
    Given user is already on Login Page
    When user enters "superadmin@pluraltechnology.com" and "Plural@1234"
    Then user is redirected to the Super Admin Dashboard
    Then user logout from the application
    Then Close the browser
    
@tag2
Scenario Outline: Unsuccessful login with valid username and invalid password
    Given user is already on Login Page
    When user enters "superadmin@pluraltechnology.com" and "Plural@12"
    Then an error message Invalid Password is displayed
    And user is still on the Login Page
    Then Close the browser
@tag3
Scenario Outline: Unsuccessful login with invalid username
    Given user is already on Login Page
    When user enters "superadmin@plural.com" and "Plural@1234"
    Then an error message Invalid Email/Mobile Number is displayed
    And user is still on the Login Page
    Then Close the browser
    
@tag4
Scenario: User clicks on Login button without filling username and password
    Given user is already on Login Page
    When the user leaves blank fileds and clicks on the Login button
    Then an error message Email / Mobile Number is required is displayed
    And an error message Password is required is displayed
    Then Close the browser


    
    


   
