Feature: Checking User Registration

Scenario Outline: To check the Creating New customer account page with valid and invalid data

Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User clicks the link Create an account
And User enters the valid '<FirstName>' in firstname textbox 
And User enters the valid '<LastName>' in lstname textbox 
And User enters the invalid '<InvalidEmail>' in email textbox 
And User enters the valid '<Password>' in password textbox 
And User enters the valid '<ConfirmPassword>' in confirm password textbox
And User clicks  Create an account button. 
Then User verifies the '<error>' message displayed under the email textbox
When User re-enters the email with valid data '<ValidEmail>'
And User clicks  Create an account button. 
Then User verifies thank you '<message>' in the next page 
Examples:
|FirstName|LastName|InvalidEmail|Password|ConfirmPassword|error|ValidEmail|message|
|Deepak|SVSD|svsdeepak|npkC8XBWxs_X9T3|npkC8XBWxs_X9T3|Please enter a valid email address (Ex: johndoe@domain.com).|svsdeepak110081@gmail.com|Thank you for registering with Main Website Store.|




