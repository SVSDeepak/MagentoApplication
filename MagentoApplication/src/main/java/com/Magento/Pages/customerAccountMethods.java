package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.customerAccountObjects;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;


public class customerAccountMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static customerAccountObjects obj;

	/*
	 * Method for enterning data in firstname textbox
	 */

	public static void enteringFirstName(String str) {
		logger1.log(Status.INFO ,"Entering First Name");
		obj = new customerAccountObjects();
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.firstNameElement));
			obj.firstNameElement.sendKeys(str);
			logger1.log(Status.PASS ,"First name entered Successfully ");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem with entering first name : "+e);
			System.out.println("Exception in Enteringfirstname method : " + e);
		}
	}

	/*
	 * Method for enterning data in LastName textbox
	 */

	public static void enteringLastName(String str) {
		logger1.log(Status.INFO ,"Entering last name ");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.lastnameElement));
			obj.lastnameElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the last name");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering the data in textbox : "+e);
			System.out.println("Exception in EnteringLastName method : " + e);
		}
	}

	/*
	 * Method for enterning data in email textbox
	 */

	public static void enteringEmail(String str) {
		logger1.log(Status.INFO ,"Entering email ");
		try {

			obj.emailElement.clear();
			obj.emailElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the email");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering email : "+e);
			System.out.println("Exception in Enteringemail method : " + e);
		}
	}

	/*
	 * Method for enterning data in password textbox
	 */

	public static void enteringPassword(String str) {
		logger1.log(Status.INFO ,"Entering password ");
		try {

			js.executeScript("arguments[0].setAttribute('value',arguments[1]);", obj.passwordElement, str);
			logger1.log(Status.PASS ,"Successfully entered the password");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering password : "+e);
			System.out.println("Exception in EnteringPassword method : " + e);
		}
	}

	/*
	 * Method for enterning data in Confirmpassword textbox
	 */

	public static void enteringConfirmPassword(String str) {
		logger1.log(Status.INFO ,"Entering confirm password ");
		try {

			js.executeScript("arguments[0].setAttribute('value',arguments[1]);", obj.confirmPasswordElement, str);
			logger1.log(Status.PASS ,"Successfully entered the confirm password");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering confirm password : "+e);
			System.out.println("Exception in EnteringConfirmPassword method : " + e);
		}
	}

	/*
	 * Method for clicking createAnAccount
	 */

	public static void clickingCreateAnAccountButton() {
		logger1.log(Status.INFO, "Clicking create an account button");
		try {
			js.executeScript("arguments[0].click()", obj.createAnAccountElement);
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in  clickingCreateAnAccountButton method : " + e);
		}
	}

	/*
	 * Method for getting error message text
	 */

	public static String errorMessage() {
		logger1.log(Status.INFO, "Getting the error message ");
		String text = null;
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
			text = obj.errorElement.getText();
			logger1.log(Status.PASS, "Successfully got the message ");
			capturingScreenShot.screenShot("Error Message1");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("error message1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the  message : "+e);
			System.out.println("Exception in  errorMessage method : " + e);
		}
		return text;

	}

}
