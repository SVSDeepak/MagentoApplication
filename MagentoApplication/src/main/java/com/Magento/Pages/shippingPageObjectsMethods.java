package com.Magento.Pages;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.Magento.Browser.Browser;
import com.Magento.Locators.shippingPageObjects;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class shippingPageObjectsMethods extends Browser{
	
	/*
	 * Necessary objects declared globally
	 */

	static shippingPageObjects obj;
	
	/*
	 * Method for enterning data in firstname textbox
	 */

	public static void enteringFirstName(String str) {
		logger1.log(Status.INFO ,"Entering First Name");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.firstNameElement));
			obj.firstNameElement.clear();
			obj.firstNameElement.sendKeys(str);
			logger1.log(Status.PASS ,"First name entered Successfully ");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem with entering first name : "+e);
			System.out.println("Exception in enteringFirstName method : " + e);
		}
	}
	
	/*
	 * Method for enterning data in lastname textbox
	 */

	public static void enteringLastName(String str) {
		logger1.log(Status.INFO ,"Entering last name ");
		try {

			obj.lastNameElement.clear();
			obj.lastNameElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the last name");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in enteringFirstName method : " + e);
		}
	}
	
	/*
	 * Method for enterning data in streetAdress textbox
	 */

	public static void enteringstreetAdress(String str) {
		logger1.log(Status.INFO ,"Entering street address ");
		try {

			obj.streetAdressElement.clear();
			obj.streetAdressElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the street address");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in enteringstreetAdress method : " + e);
		}
	}
	
	/*
	 * Method for enterning data in city textbox
	 */

	public static void enteringcity(String str) {
		logger1.log(Status.INFO ,"Entering city ");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.cityElement));
			obj.cityElement.clear();
			obj.cityElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the city");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in enteringscity method : " + e);
		}
	}
	
	/*
	 * Method for enterning data in zip textbox
	 */

	public static void enteringzip(String str) {
		logger1.log(Status.INFO ,"Entering ZIP ");
		try {

			obj.zipElement.clear();
			obj.zipElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the ZIP");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in enteringzip method : " + e);
		}
	}
	
	/*
	 * Method for enterning data in phonenumber textbox
	 */

	public static void enteringphonenumber(String str) {
		logger1.log(Status.INFO ,"Entering phone number ");
		try {

			obj.phoneNumberElement.clear();
			obj.phoneNumberElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the phone number");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in enteringphonenumber method : " + e);
		}
	}
	
	/*
	 * Method for clicking shippingMethod radio button
	 */

	public static void clickingshippingMethod() {
		logger1.log(Status.INFO, "Clicking Shipping radio button");
		try {

			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			while(!obj.shippingMethodsElement.isSelected())
			{
				try
				{
					obj.shippingMethodsElement.click();
				}catch(Exception e) {}
			}
			
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingshippingMethod method : " + e);
		}
	}
	
	/*
	 * Method for clicking addAdress button
	 */

	public static void clickingAddAddress() {
		logger1.log(Status.INFO, "Clicking add address button");
		obj=new shippingPageObjects();
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.addressButtonElement));
			js.executeScript("arguments[0].click()", obj.addressButtonElement);
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingaddAddress method : " + e);
		}
	}
	
	/*
	 * Method for clicking saveAdress button
	 */
	
	public static void clickingSaveAddress() {
		logger1.log(Status.INFO, "Clickink save address button");
		try {

			if(!obj.saveAddressCheckBoxButton.isSelected())
			js.executeScript("arguments[0].click()", obj.saveAddressCheckBoxButton);
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingSaveAddress method : " + e);
		}
	}
	
	/*
	 * Method for clicking nextPage button
	 */
	
	public static void clickingNextPageButton() {
		logger1.log(Status.INFO, "Clicking next page button");
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.nextpageElement));
			obj.nextpageElement.click();
			logger1.log(Status.PASS, "Successfully clicked the button ");

		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingNextPageButtonmethod : " + e);
		}
	}
	
	/*
	 * Method for selecting state
	 */
	
	public static void seletingState(String str) {
		logger1.log(Status.INFO, "Selecting state ");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.stateElement));
			select=new Select(obj.stateElement);
			select.selectByContainsVisibleText(str);
			logger1.log(Status.PASS, "Successfully selected the state ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in selecting state : "+e);
			System.out.println("Exception in seletingState : " + e);
		}
	}
	
	
	/*
	 * Method for getting error message text
	 */

	public static String errorMessage() {
		logger1.log(Status.INFO, "Getting the error message ");
		String text = null;
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.errorMessageTextElement));
			text = obj.errorMessageTextElement.getText();
			logger1.log(Status.PASS, "Successfully got the error message ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("error message2"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the error message : "+e);
			System.out.println("Exception in  errorMessage method : " + e);
		}
		return text;
	
	}
	
	/*
	 * Method for clicking shiphere button
	 */
	
	public static void clickingShipHere() {
		logger1.log(Status.INFO, "Clicking ship here button");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.shipHereButtonElement));
			obj.shipHereButtonElement.click();
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingShipHere method : " + e);
		}
	}
	
	

}
