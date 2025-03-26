package com.Magento.StepDefinition;

import org.testng.Assert;

import com.Magento.Browser.Browser;
import com.Magento.Pages.addToCartPageMethods;
import com.Magento.Pages.homePageMethods;
import com.Magento.Pages.shoppingCartPageMethods;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class validatingCartSummaryStepDefinition extends Browser{
	
	@When("User navigates to shopping cart")
	public void user_navigates_to_shopping_cart() {
		addToCartPageMethods.clickingShoppingCartLink();
	}
	
	@Then("User verifies the selected items names {string} , {string} and Total Cost {string}")
	public void user_verifies_the_selected_items_names_and_total_cost(String string, String string2, String string3) {
		try
		   {
			   Assert.assertEquals(shoppingCartPageMethods.product1TextMessage(), string);
			   Assert.assertEquals(shoppingCartPageMethods.product2TextMessage(), string2);
			   Assert.assertEquals(shoppingCartPageMethods.costTextMessage(), string3);
			   logger1.log(Status.PASS, "Expected and Actual Matched");
			   
		   }
		   catch(Exception e)
		   {
			   logger1.log(Status.FAIL, "Mismatch in Expected and actual : "+e);
			   System.out.println(e);
		   }
	}
	
	@And("User empties the cart elements")
	public void user_empties_the_cart_elements() {
	  homePageMethods.deleteingCartData();
	}

}
