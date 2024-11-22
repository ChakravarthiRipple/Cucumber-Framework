
Feature: Super Admin Login Functionality

Scenario Outline: Successful login with valid username and password
    Given user is already on Login Page
    When user enters "superadmin@pluraltechnology.com" and "Plural@1234"
    Then user is redirected to the Super Admin Dashboard
    Then user logout from the application
    Then Close the browser    

Scenario Outline: Unsuccessful login with valid username and invalid password
    Given user is already on Login Page
    When user enters "superadmin@pluraltechnology.com" and "Plural@12"
    Then an error message Invalid Password is displayed
    And user is still on the Login Page
    Then Close the browser   

Scenario Outline: Unsuccessful login with invalid username
    Given user is already on Login Page
    When user enters "superadmin@plural.com" and "Plural@1234"
    Then an error message Invalid Email/Mobile Number is displayed
    And user is still on the Login Page
    Then Close the browser    

Scenario: User clicks on Login button without username and password
    Given user is already on Login Page
    When the user leaves blank fileds and clicks on the Login button
    Then an error message Email / Mobile Number is required is displayed
    And an error message Password is required is displayed
    Then Close the browser

Scenario: Successful login Valid Email ID with Valid OTP
    Given user is already on Login Page
    When user enter Email/Mobile and Click on Send button
    When Login Valid Email ID With Valid OTP
    Then user is redirected to the Super Admin Dashboard
    Then user logout from the application
    Then Close the browser

Scenario: Unsuccessful login Email ID with Inavlid OTP 
    Given user is already on Login Page
    When user enter Email/Mobile and Click on Send button
    When Login Valid Email ID With Invalid OTP
    Then Close the browser


Scenario: Unsuccessful login Email ID with Expired OTP 
   Given user is already on Login Page
    When user enter Email/Mobile and Click on Send button
    When Unsuccessful login Email ID with Expired OTP
    Then Close the browser


    
    
  


    
    


   
