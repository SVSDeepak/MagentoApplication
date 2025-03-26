package com.Magento.StepDefinition;

import java.util.List;

import org.testng.Assert;

import com.Magento.Browser.Browser;
import com.Magento.Excel.excelDataManupulations;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.signInObjectsMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class signInFunctionStepDefinition extends Browser{

	@When("User click the Sign in link in the homepage")
	public void user_click_the_sign_in_link_in_the_homepage() {
		homePageMethods.clickSignIN();
	}

	@When("user Enters invalid password in the Login Credentials")
	public void user_enters_invalid_password_in_the_login_credentials(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				0);
		dataTable = DataTable.create(credentials);
		signInObjectsMethods.enteringEmail(dataTable.cell(2, 0));
		signInObjectsMethods.enteringPassword(dataTable.cell(2, 1));

	}

	@When("User click the sign in button")
	public void user_click_the_sign_in_button() {
		signInObjectsMethods.clickingSignInButton();
	}

	@Then("User verifies for the error {string}")
	public void user_verifies_for_the_error(String string) {
		try {
			Assert.assertEquals(signInObjectsMethods.errorMessage(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Eception in signinstepdefinition : " + e);
		}
	}

	@Then("user Enters the valid Login Credentials")
	public void user_enters_the_valid_login_credentials(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				0);
		dataTable = DataTable.create(credentials);
		signInObjectsMethods.enteringEmail(dataTable.cell(1, 0));
		signInObjectsMethods.enteringPassword(dataTable.cell(1, 1));
	}

	@Then("User verifies the {string}")
	public void user_verifies_the(String string) {
		try {
			Assert.assertEquals(homePageMethods.homePageText(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Eception in signinstepdefinition : " + e);
		}
	}

}
