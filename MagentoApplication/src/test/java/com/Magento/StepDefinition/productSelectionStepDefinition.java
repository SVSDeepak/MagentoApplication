package com.Magento.StepDefinition;

import java.util.List;

import org.testng.Assert;

import com.Magento.Browser.Browser;
import com.Magento.Excel.excelDataManupulations;
import com.Magento.Pages.addToCartPageMethods;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.searchResultsMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class productSelectionStepDefinition extends Browser{
	
	@When("User Enter the data {string} in the search textbox")
	public void user_enter_the_data_in_the_search_textbox(String string) {
	    homePageMethods.enteringSearchData(string);
	}

	@And("User selects the shorts for men form the Auto Suggestion {string}")
	public void user_selects_the_shorts_for_men_form_the_auto_suggestion(String string) {
	  homePageMethods.selectingSearchData(string);
	}

	@And("User clicks on the {string} from the search results")
	public void user_clicks_on_the_from_the_search_results(String string) {
	   searchResultsMethods.selectingSearchData(string);
	}

	@And("User Selects the size,colour and quatity")
	public void user_selects_the_size_colour_and_quatity(DataTable dataTable) {
		List<List<String>> credentials = excelDataManupulations.datFromExcel(
				System.getProperty("user.dir")+"\\src\\test\\resources\\com.Magento.Excel\\Exceldata.xlsx",
				1);
		dataTable = DataTable.create(credentials);
		addToCartPageMethods.selectingSizeData(dataTable.cell(1, 0));
		addToCartPageMethods.selectingColourData(dataTable.cell(1, 1));
		addToCartPageMethods.enteringQuantity(dataTable.cell(1, 2));
	}

	@And("User clicks the Add to cart button")
	public void user_clicks_the_add_to_cart_button() {
	    addToCartPageMethods.clickingAddToCartButton();
	}

	@Then("Verify whether product added to cart {string} is displayed.")
	public void verify_whether_product_added_to_cart_is_displayed(String string) {
		try {
			Assert.assertEquals(addToCartPageMethods.conformationMessage(), string);
			logger1.log(Status.PASS, "Expected and Actual Matched");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			System.out.println("Exception in productselection : " + e);
		}
	}


}
