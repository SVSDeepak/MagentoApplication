Feature: Checking Login,product search,Adding product to cart

Scenario Outline: Auto suggestion feature in search and addition of product in the cart.

Given User opens the browser
And User navigates to the application Url "https://magento.softwaretestingboard.com/"
When User click the Sign in link in the homepage
And user Enters the valid Login Credentials
|Exceldata.xlsx|
And User click the sign in button
And User Enter the data "shorts" in the search textbox
And User selects the shorts for men form the Auto Suggestion '<options>'
And User clicks on the '<short>' from the search results
And User Selects the size,colour and quatity
|Exceldata.xlsx| 
And User clicks the Add to cart button
Then Verify whether product added to cart '<message>' is displayed.  
Examples:
|options|short|message|
|shorts for men|Rapha Sports Short|You added Rapha Sports Short to your shopping cart.| 