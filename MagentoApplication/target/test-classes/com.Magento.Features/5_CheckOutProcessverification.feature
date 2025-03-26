Feature: Checking the checkout process

Scenario Outline: To check chekout process with valid and invalid data

Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User click the Sign in link in the homepage
And user Enters the valid Login Credentials
|Exceldata.xlsx|
And User click the sign in button
And User clicks the cart icon on the homepage
And User then clicks the Proceed to chekout button
And User enters the shipping address fields with valid data except zip/postal code textbox
|Exceldata.xlsx|
Then User verifies the '<warning>' didplayed under zip/postal code textbox
When User re-Enters the valid data in zip/postal code textbox
|Exceldata.xlsx|
And User enters remaining data
|Exceldata.xlsx|
And User clicks the next button
And User clicks the place order button
Then User verifies the Thank you '<message>'

Examples:
|warning|message|
|Provided Zip/Postal Code seems to be invalid. Example: 12345-6789; 12345. If you believe it is the right one you can ignore this notice.|Thank you for your purchase!|
 


