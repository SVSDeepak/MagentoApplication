package com.Magento.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.Magento.Browser.Browser;
import com.Magento.Locators.signInObjects;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class signInObjectsMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static signInObjects obj;

	/*
	 * Method for enterning data in email textbox
	 */

	public static void enteringEmail(String str) {
		logger1.log(Status.INFO ,"Entering email ");
		obj = new signInObjects();
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
			obj.emailElement.clear();
			obj.emailElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the email");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering email : "+e);
			System.out.println("Exception in enteringEmail method : " + e);
		}
	}

	/*
	 * Method for enterning data in password textbox
	 */

	public static void enteringPassword(String str) {
		logger1.log(Status.INFO ,"Entering password ");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
			obj.passwordElement.clear();
			obj.passwordElement.sendKeys(str);
			logger1.log(Status.PASS ,"Successfully entered the password");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in entering password : "+e);
			System.out.println("Exception in enteringPassword method : " + e);
		}
	}

	/*
	 * Method for clicking sign in button
	 */

	public static void clickingSignInButton() {
		logger1.log(Status.INFO, "Clicking Sign in link");
		try {
			js.executeScript("arguments[0].click()", obj.signInElement);
			logger1.log(Status.PASS, "Successfully clicked the link ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the link : "+e);
			System.out.println("Exception in clickingSignInButton method : " + e);
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
			capturingScreenShot.screenShot("ErrorMessageforinvalidsignin");
			logger1.log(Status.PASS, "Successfully got the message ");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("error message5"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting the  message : "+e);
			System.out.println("Exception in  errorMessage method : " + e);
		}
		return text;

	}

}
