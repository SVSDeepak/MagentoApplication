package com.Magento.StepDefinition;


import org.testng.Assert;

import com.Magento.Browser.Browser;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.signOutPageMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.*;

public class loggingOutFunctionalityStepDefinition extends Browser {
	

	@When("User clicks the dropdown and clicks sign out button beside the username")
	public void user_clicks_the_dropdown_and_clicks_sign_out_button_beside_the_username() {
	   homePageMethods.clickingSignOutButton();
	}
	
	@Then("User verifies sign out {string}")
	public void user_verifies_sign_out(String string) {
		try {
			Assert.assertEquals(signOutPageMethods.signOutText(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Exception in loggingOutstepdefinition : " + e);
		}
	}

}
