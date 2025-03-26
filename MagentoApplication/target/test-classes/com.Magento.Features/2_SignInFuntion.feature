Feature: Checking SignIn functionality

Scenario Outline: To check SignIn functionality with valid and invalid data
Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User click the Sign in link in the homepage
And user Enters invalid password in the Login Credentials
|Exceldata.xlsx|
And User click the sign in button
Then User verifies for the error '<message>'
When user Enters the valid Login Credentials
|Exceldata.xlsx|
And User click the sign in button
Then User verifies the "Home Page"

Examples:
|message|
|The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|
