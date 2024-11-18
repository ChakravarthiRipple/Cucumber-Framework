@tag
Feature: Ripple Smart Login Feature

@tag1
Scenario Outline: Ripple Smart Login Test Scenario

Given user is already on Login Page
When title of login page is Ripple
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user logout from the application
Then Close the browser


Examples:
	| username | password |
	| superadmin@pluraltechnology.com  | Plural@1234 |
		
