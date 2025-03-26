package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.reviewAndPaymentObjects;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class reviewAndPaymentpageMethods extends Browser{
	

	/*
	 * Necessary objects declared globally
	 */

	static reviewAndPaymentObjects obj;
	
	/*
	 * Method for getting thankYouMessage text
	 */

	public static String thankYouMessage(String str) {
		logger1.log(Status.INFO, "Getting the thank you message ");
		String text = null;
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(obj.thankYouMessageElement, str));
			text = obj.thankYouMessageElement.getText();
			capturingScreenShot.screenShot("Checkoutconformationmessage");
			logger1.log(Status.PASS, "Successfully got the  message ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("thankyoumessage1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the message : "+e);
			System.out.println("Exception in  thankYouMessage method : " + e);
		}
		return text;
	
	}
	
	/*
	 * Method for clicking place order button
	 */
	
	public static void clickingplaceorderButton() {
		logger1.log(Status.INFO, "Clicking the place order button ");
		obj=new reviewAndPaymentObjects();
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.placeOrderButtonElement));
			js.executeScript("arguments[0].click()", obj.placeOrderButtonElement);
			logger1.log(Status.PASS, "Successfully clicked the button ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : "+e);
			System.out.println("Exception in clickingplaceorderButton: " + e);
		}
	}

}
