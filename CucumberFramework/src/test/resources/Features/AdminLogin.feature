@tag
Feature: Ripple Smart Admin Login Feature

@tag1
Scenario Outline: Ripple Smart Admin Login Test Scenario

Given user is already on Login Page
When title of login page is Ripple
Then user enters "<username>" and "<password>"
Then user should be redirected to the Admin dashboard
Then user logout from the application
Then Close the browser


Examples:
	| username | password |
	| chakravarthi@ripplemetering.com  | Chakri@932 |


	
		
		
