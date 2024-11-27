Feature: Super Admin Login Functionality

  Background: 
    Given user is already on Login Page
    
    

  Scenario Outline: Successful login with valid username and password
    When user enters "<username>" and "<password>"
    Then user is redirected to the Super Admin Dashboard
    Then user logout from the application

    Examples: 
      | username                                   | password     |
      | Ramakrishna.gandikota@pluraltechnology.com | Ripple@#123  |
      | muscle-make@jw2rdthr.mailosaur.net         | Chakri@932   |
      | ripple.shoaib@gmail.com                    | 12345@Ripple |
      | Ripple.rajveer@gmail.com                   | 12345@Ripple |
      | deeksha.ripple@gmail.com                   | 12345@Ripple |
      | ripple.nidhi@gmail.com                     | 12345@Ripple |
      | nisar@ripplemetering.com                   | 12345@Ripple |

  Scenario Outline: Unsuccessful login with valid username and invalid password
    When user enters "<username>" and "<password>"
    Then an error message Invalid Password is displayed
    And user is still on the Login Page

    Examples: 
      | username                           | password     |
      | superadmin@pluraltechnology.com    | Plural@12    |
      | muscle-make@jw2rdthr.mailosaur.net | Chakri@9     |
      | ripple.shoaib@gmail.com            | 12345@Ripp   |
      | Ripple.rajveer@gmail.com           | 12345@Ripple |
      | deeksha.ripple@gmail.com           | 12345@Ripple |
      | ripple.nidhi@gmail.com             | 12345@Ripple |
      | nisar@ripplemetering.com           | 12345@Ripple |

  Scenario Outline: Unsuccessful login with invalid username
    When user enters "<username>" and "<password>"
    Then an error message Invalid Email/Mobile Number is displayed
    And user is still on the Login Page

    Examples: 
      | username                      | password     |
      | superadmin@plural.com         | Plural@1234  |
      | muscle-make@jwr.mailosaur.net | Chakri@932   |
      | riple.shoib@gmail.com         | 12345@Ripple |
      | Ripple.rajveer@gmail.com      | 12345@Ripple |
      | deeksha.ripple@gmail.com      | 12345@Ripple |
      | ripple.nidhi@gmail.com        | 12345@Ripple |
      | nisar@ripplemetering.com      | 12345@Ripple |

  Scenario: User clicks on Login button without username and password
    When the user leaves blank fileds and clicks on the Login button
    Then an error message Email / Mobile Number is required is displayed
    And an error message Password is required is displayed

  Scenario: Successful login Valid Email ID with Valid OTP
    When user enter Email/Mobile and Click on Send button
    When Login Valid Email ID With Valid OTP
    Then user is redirected to the Super Admin Dashboard
    Then user logout from the application

  Scenario: Unsuccessful login Email ID with Inavlid OTP
    When user enter Email/Mobile and Click on Send button
    When Login Valid Email ID With Invalid OTP

  Scenario: Unsuccessful login Email ID with Expired OTP
    When user enter Email/Mobile and Click on Send button
    When Unsuccessful login Email ID with Expired OTP

  Scenario: Verify OTP Filed verification

  Scenario: forgot password functionality

  Scenario: forgot password pop-up buttons and links

  Scenario: reset password pop-up buttons and links

  Scenario: successfull login with setting new password with confirm password

  Scenario: that deleted user not able to login into application

  Scenario: that the inactive user unable to login into application

  Scenario: locked user unable to login into application

  Scenario: Inactive project for a user, unable to logi into application

  Scenario: resend OTP button functionality oin reset password pop-up
