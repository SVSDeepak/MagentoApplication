package com.Magento.StepDefinition;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import java.util.List;

import org.testng.Assert;

import com.Magento.Browser.Browser;
import com.Magento.Excel.excelDataManupulations;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.reviewAndPaymentpageMethods;
import com.Magento.Pages.shippingPageObjectsMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;

public class checkOutProcessStepDefinition extends Browser{
	
	
	@When("User clicks the cart icon on the homepage")
	public void user_clicks_the_cart_icon_on_the_homepage() {
	   homePageMethods.clickCartIcon();
	}

	@When("User then clicks the Proceed to chekout button")
	public void user_then_clicks_the_proceed_to_chekout_button() {
			homePageMethods.clickckingProceedToCart();
	}

	@When("User enters the shipping address fields with valid data except zip\\/postal code textbox")
	public void user_enters_the_shipping_address_fields_with_valid_data_except_zip_postal_code_textbox(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				2);
		dataTable = DataTable.create(credentials);
		shippingPageObjectsMethods.clickingAddAddress();
		shippingPageObjectsMethods.enteringFirstName(dataTable.cell(1, 0));
		shippingPageObjectsMethods.enteringLastName(dataTable.cell(1, 1));
		shippingPageObjectsMethods.seletingState(dataTable.cell(1, 4));
		shippingPageObjectsMethods.enteringzip(dataTable.cell(1, 5));
		shippingPageObjectsMethods.enteringstreetAdress(dataTable.cell(1, 2));
		shippingPageObjectsMethods.enteringcity(dataTable.cell(1, 3));
		shippingPageObjectsMethods.enteringphonenumber(dataTable.cell(1, 7));
		
	}

	@Then("User verifies the {string} didplayed under zip\\/postal code textbox")
	public void user_verifies_the_didplayed_under_zip_postal_code_textbox(String string) {
		try {
			Assert.assertEquals(shippingPageObjectsMethods.errorMessage(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Exception in checkOutProcessStepdefinition : " + e);
		}
	}

	@When("User re-Enters the valid data in zip\\/postal code textbox")
	public void user_re_enters_the_valid_data_in_zip_postal_code_textbox(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				2);
		dataTable = DataTable.create(credentials);
		shippingPageObjectsMethods.enteringzip(dataTable.cell(1, 6));
	}
	
	@When("User enters remaining data")
	public void user_enters_remaining_data(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				2);
		dataTable = DataTable.create(credentials);
		shippingPageObjectsMethods.enteringFirstName(dataTable.cell(1, 0));
		shippingPageObjectsMethods.enteringLastName(dataTable.cell(1, 1));
		shippingPageObjectsMethods.enteringstreetAdress(dataTable.cell(1, 2));
		shippingPageObjectsMethods.enteringcity(dataTable.cell(1, 3));
		shippingPageObjectsMethods.enteringphonenumber(dataTable.cell(1, 7));
		shippingPageObjectsMethods.clickingSaveAddress();
		shippingPageObjectsMethods.clickingShipHere();
		shippingPageObjectsMethods.clickingshippingMethod();
		
		
		
	}

	@When("User clicks the next button")
	public void user_clicks_the_next_button() {
		
		shippingPageObjectsMethods.clickingNextPageButton();

	}

	@When("User clicks the place order button")
	public void user_clicks_the_place_order_button() {
	  reviewAndPaymentpageMethods.clickingplaceorderButton();
	}

	@Then("User verifies the Thank you {string}")
	public void user_verifies_the_thank_you(String string) {
		try {
			Assert.assertEquals(reviewAndPaymentpageMethods.thankYouMessage(string), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Exception in checkOutProcessStepdefinition : " + e);
		}
	}	

}
