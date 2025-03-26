package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.shoppingCartPage;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class shoppingCartPageMethods extends Browser{

	/*
	 * Necessary objects declared globally
	 */

	static shoppingCartPage obj;
	
	
	/*
	 * Method for getting product1Text message 
	 */

	public static String product1TextMessage() {
		logger1.log(Status.INFO, "Getting the product1Text message ");
		obj=new shoppingCartPage();
		String text = null;
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.product1TextElement));
			text = obj.product1TextElement.getText();
			logger1.log(Status.PASS, "Successfully got the message ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("message2"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the  message : "+e);
			System.out.println("Exception in product1TextMessage method : " + e);
		}
		return text;
	}
	
	/*
	 * Method for getting product2Text message 
	 */

	public static String product2TextMessage() {
		logger1.log(Status.INFO, "Getting the product2Text message ");
		String text = null;
		try {

			text = obj.product2TextElement.getText();
			logger1.log(Status.PASS, "Successfully got the message ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the  message : "+e);
			System.out.println("Exception in product2TextMessage method : " + e);
		}
		return text;
	}
	
	/*
	 * Method for getting costText message 
	 */

	public static String costTextMessage() {
		logger1.log(Status.INFO, "Getting the costText message ");
		String text = null;
		try {

			text = obj.costTextElement.getText();
			capturingScreenShot.screenShot("cartpagewithourproducts");
			logger1.log(Status.PASS, "Successfully got the message ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the  message : "+e);
			System.out.println("Exception in costTextMessage method : " + e);
		}
		return text;
	}
}
