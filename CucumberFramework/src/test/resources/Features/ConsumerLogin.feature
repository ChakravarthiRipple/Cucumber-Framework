@tag
Feature: Login Functionality

@tag1
Scenario Outline: Successful login with valid username and password
    Given user is already on Login Page
    When user enters "chakravarthigattupelly@gmail.com" and "Chakri@932"
    Then user should be redirected to the Consumer dashboard
    Then user logout from the application
    Then Close the browser
    
@tag2
Scenario Outline: Unsuccessful login with valid username and invalid password
    Given user is already on Login Page
    When user enters "chakravarthigattupelly@gmail.com" and "Plural@12"
    Then an error message Invalid Password is displayed
    And user is still on the Login Page
    Then Close the browser
@tag3
Scenario Outline: Unsuccessful login with invalid username
    Given user is already on Login Page
    When user enters "chakravarthi@gmail.com" and "Chakri@932"
    Then an error message Invalid Email/Mobile Number is displayed
    And user is still on the Login Page
    Then Close the browser
    
    

    
    



    
    


   
