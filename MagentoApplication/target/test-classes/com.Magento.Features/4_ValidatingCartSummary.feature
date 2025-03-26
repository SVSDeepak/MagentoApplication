Feature: validating products in cart

Scenario Outline: Adding Multiple Products to Cart & Validating Cart Summary
Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User click the Sign in link in the homepage
And user Enters the valid Login Credentials
|Exceldata.xlsx|
And User click the sign in button
And User empties the cart elements
And User Enter the data "shorts" in the search textbox
And User selects the shorts for men form the Auto Suggestion '<options>'
And User clicks on the '<short>' from the search results
And User Selects the size,colour and quatity
|Exceldata.xlsx| 
And User clicks the Add to cart button
And User Enter the data "shorts" in the search textbox
And User selects the shorts for men form the Auto Suggestion '<options>'
And User clicks on the "Meteor Workout Short" from the search results
And User Selects the size,colour and quatity
|Exceldata.xlsx| 
And User clicks the Add to cart button
And User navigates to shopping cart
Then User verifies the selected items names "Rapha Sports Short" , "Meteor Workout Short" and Total Cost "$67.50"


Examples:
|options|short|message|
|shorts for men|Rapha Sports Short|You added Rapha Sports Short to your shopping cart.| 
