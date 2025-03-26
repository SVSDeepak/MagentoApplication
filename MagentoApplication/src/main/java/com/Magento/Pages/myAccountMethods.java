package com.Magento.Pages;


import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.myAccount;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class myAccountMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static myAccount obj;

	/*
	 * Method for getting Successfull registration text
	 */

	public static String registrationText() {
		logger1.log(Status.INFO, "Getting the registration text ");
		String text = null;
		obj = new myAccount();
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.registrationtextElement));
			text = obj.registrationtextElement.getText();
			capturingScreenShot.screenShot("SuccessfulRegistrationText");
			logger1.log(Status.PASS, "Successfully got the text ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("registration text1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the message : "+e);
			System.out.println("Exception in registrationtext method : " + e);
		}
		return text;

	}

	/*
	 * Method for getting myAccount text
	 */

	public static String myAccountText() {
		logger1.log(Status.INFO, "Getting the my account text ");
		String text = null;
		obj = new myAccount();
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.myAccountTextElement));
			text = obj.myAccountTextElement.getText();
			capturingScreenShot.screenShot("userRegistrationconformation");
			logger1.log(Status.PASS, "Successfully got the message ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("myaccount message1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the message : "+e);
			System.out.println("Exception in MyAccountText method : " + e);
		}
		return text;
	}

	
	

}
