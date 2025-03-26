package com.Magento.StepDefinition;

import org.testng.Assert;
import com.Magento.Browser.Browser;
import com.Magento.Browser.utility;
import com.Magento.Pages.customerAccountMethods;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.myAccountMethods;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.*;

public class userRegistrationStepDefinition extends Browser{

	@Given("User opens the browser")
	public void user_opens_the_browser() {
		
		Browser.openbrowser(utility.properties("Browser"));
	}

	@And("User navigates to the application Url {string}")
	public void user_navigates_to_the_application_url(String string) {

		Browser.navigateTourl(string);
	}

	@When("User clicks the link Create an account")
	public void user_clicks_the_link_create_an_account() {
		
		homePageMethods.clickCreateNewAccount();
	}

	@And("User enters the valid {string} in firstname textbox")
	public void user_enters_the_valid_in_firstname_textbox(String string) {
		
		customerAccountMethods.enteringFirstName(string);
	}

	@And("User enters the valid {string} in lstname textbox")
	public void user_enters_the_valid_in_lstname_textbox(String string) {
		
		customerAccountMethods.enteringLastName(string);
	}

	@And("User enters the invalid {string} in email textbox")
	public void user_enters_the_invalid_in_email_textbox(String string) {
		
		customerAccountMethods.enteringEmail(string);
	}

	@And("User enters the valid {string} in password textbox")
	public void user_enters_the_valid_in_password_textbox(String string) {
		
		customerAccountMethods.enteringPassword(string);
	}

	@And("User enters the valid {string} in confirm password textbox")
	public void user_enters_the_valid_in_confirm_password_textbox(String string) {
		
		customerAccountMethods.enteringConfirmPassword(string);
	}

	@And("User clicks  Create an account button.")
	public void user_clicks_create_an_account_button() {
		
		customerAccountMethods.clickingCreateAnAccountButton();
	}

	@Then("User verifies the {string} message displayed under the email textbox")
	public void user_verifies_the_message_displayed_under_the_email_textbox(String string) {
		
		try {
			Assert.assertEquals(customerAccountMethods.errorMessage(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println(e);
		}
	}

	@When("User re-enters the email with valid data {string}")
	public void user_re_enters_the_email_with_valid_data(String string) {
		
		customerAccountMethods.enteringEmail(string);
	}

	@Then("User verifies thank you {string} in the next page")
	public void user_verifies_thank_you_in_the_next_page(String string) {
		
		try {
			Assert.assertEquals(myAccountMethods.registrationText(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println(e);
		}
	}

}
