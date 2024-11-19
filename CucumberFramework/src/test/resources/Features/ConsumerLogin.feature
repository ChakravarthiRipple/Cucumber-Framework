@tag
Feature: Ripple Smart Consumer Login Feature

@tag1
Scenario Outline: Ripple Smart Consumer Login Test Scenario

Given user is already on Login Page
When title of login page is Ripple
Then user enters "<username>" and "<password>"
Then user should be redirected to the Consumer dashboard
Then user logout from the application
Then Close the browser


Examples:
	| username | password |
	| chakravarthigattupelly@gmail.com  | Chakri@932 |
	


	
		
		
