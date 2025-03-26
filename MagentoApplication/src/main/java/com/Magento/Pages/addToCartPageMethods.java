package com.Magento.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.Magento.Browser.Browser;
import com.Magento.Locators.addToCartPage;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class addToCartPageMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static addToCartPage obj;

	/*
	 * Method for dynamically selecting data from size auto suggestions
	 */

	public static void selectingSizeData(String str) {
		
		logger1.log(Status.INFO,"Selecting the Size of the shorts");
		obj = new addToCartPage();
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(obj.sizeList));
			for (WebElement e : obj.sizeList) {
				if (e.getText().contains(str)) {
					js.executeScript("arguments[0].click()", e);
					break;
				}
			}
			logger1.log(Status.PASS,"Size of the shorts selected Successfully");
		} catch (Exception e) {
			logger1.log(Status.FAIL,"Problem with selecting size of the shorts :"+e);
			System.out.println("Exception in selectingsSizeData method : " + e);
		}
	}

	/*
	 * Method for dynamically selecting data from colour auto suggestions
	 */

	public static void selectingColourData(String str) {
		logger1.log(Status.INFO,"Selecting the colour of the shorts");
		try {

			for (WebElement e : obj.colourList) {
				if (e.getDomAttribute("option-label").equalsIgnoreCase(str)) {
					js.executeScript("arguments[0].click()", e);
					break;
				}
			}
			logger1.log(Status.PASS,"Colour of the shorts selected Successfully");

		} catch (Exception e) {
			logger1.log(Status.FAIL,"Problem with selecting colour of the shorts :"+e);
			System.out.println("Exception in selectingsColourData method : " + e);
		}
	}

	/*
	 * Method for entering data in Quantity textbox
	 */

	public static void enteringQuantity(String str) {
		logger1.log(Status.INFO,"Entering quantity of shorts needed");
		try {
			js.executeScript("arguments[0].setAttribute('value', '');", obj.quantityElement);
			js.executeScript("arguments[0].setAttribute('value',arguments[1]);", obj.quantityElement, str);
			logger1.log(Status.PASS,"Number of shorts entered Successfully");
		} catch (Exception e) {
			logger1.log(Status.FAIL,"Problem with entering quantity of the shorts :"+e);
			System.out.println("Exception in EnteringQuantity method : " + e);
		}
	}

	/*
	 * Method for clicking AddToCart Button
	 */

	public static void clickingAddToCartButton() {
		logger1.log(Status.INFO,"Clicking Add to cart Button");
		try {
			js.executeScript("arguments[0].click()", obj.addTocartButtonElement);
			logger1.log(Status.PASS ,"Successfully clicked the button");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in clicking the button : "+e);
			System.out.println("Exception in clickingAddToCartButton method : " + e);
		}
	}

	/*
	 * Method for getting conformation message text
	 */

	public static String conformationMessage() {
		logger1.log(Status.INFO ,"Getting Conformation Message");
		String text = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.conformationMessageElement));
			text = obj.conformationMessageElement.getText();
			capturingScreenShot.screenShot("Addedtocartconformationmessage");
			logger1.log(Status.PASS ,"Got the message successfully");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("ConformationMessage1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Some error in getting conformation message : "+e);
			System.out.println("Exception in  conformationMessage method : " + e);
		}
		return text;

	}
	
	/*
	 * Method for clicking shoppingCartLink
	 */

	public static void clickingShoppingCartLink() {
		logger1.log(Status.INFO ,"Clicking the shopping cart Link");
		try {
			act.moveToElement(obj.shoppingCartElement).click().build().perform();
			logger1.log(Status.PASS ,"Clicked the link successfully");
		} catch (Exception e) {
			logger1.log(Status.FAIL ,"Problem in clicking the link : "+e);
			System.out.println("Exception in clickingShoppingCartLink method : " + e);
			logger1.log(Status.FAIL ,"Problem in clicking the link : "+e);
		}
	}
}
