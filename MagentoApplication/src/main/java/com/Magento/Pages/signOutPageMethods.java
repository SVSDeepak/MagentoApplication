package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.signOutPage;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class signOutPageMethods extends Browser {
	
	/*
	 * Necessary objects declared globally
	 */

	static signOutPage obj;

	/*
	 * Method for getting SignOut text
	 */

	public static String signOutText() {
		logger1.log(Status.INFO, "Getting the Signed out text ");
		String text = null;
		obj = new signOutPage();
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.signOutTextElement));
			text = obj.signOutTextElement.getText();
			capturingScreenShot.screenShot("SignOutMessage");
			logger1.log(Status.PASS, "Successfully got the text ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("Text1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the text : "+e);
			System.out.println("Exception in signOutText method : " + e);
		}
		return text;

	}

}
