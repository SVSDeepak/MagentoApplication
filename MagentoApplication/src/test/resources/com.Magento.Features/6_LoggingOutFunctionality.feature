Feature: Checking the logout functionality

Scenario Outline: Checking logging out functionality and verifying session ending.

Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User click the Sign in link in the homepage
And user Enters the valid Login Credentials
|Exceldata.xlsx|
And User click the sign in button
And User clicks the dropdown and clicks sign out button beside the username
Then User verifies sign out '<message>'
And User verifies the "Home Page"
Examples:
|message|
|You are signed out|