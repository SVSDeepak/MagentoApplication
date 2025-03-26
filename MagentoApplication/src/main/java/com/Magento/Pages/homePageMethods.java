package com.Magento.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Magento.Browser.Browser;
import com.Magento.Locators.homePageObjects;
import com.Magento.ScreenShot.capturingScreenShot;
import com.aventstack.extentreports.Status;

public class homePageMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static homePageObjects obj;

	/*
	 * Method for clicking new Account link
	 */

	public static void clickCreateNewAccount() {
		logger1.log(Status.INFO, "Clicking the Create New account link");
		obj = new homePageObjects();
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.createNewAccountLink));
			obj.createNewAccountLink.click();
			logger1.log(Status.PASS, "Successfully clicked the link");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the link : " + e);
			System.out.println("Exception in clickCreateNewAccount method : " + e);
		}
	}

	/*
	 * Method for clicking new Sign In link
	 */

	public static void clickSignIN() {
		logger1.log(Status.INFO, "Clicking the Sign In link");
		obj = new homePageObjects();
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.signInLink));
			obj.signInLink.click();
			logger1.log(Status.PASS, "Successfully clicked the link");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the link : " + e);
			System.out.println("Exception in clickSignIN method : " + e);
		}
	}

	/*
	 * Method for getting home page text
	 */

	public static String homePageText() {
		logger1.log(Status.INFO, "Getting home page text");
		obj = new homePageObjects();
		String text = null;
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.homePagetext));
			text = obj.homePagetext.getText();
			logger1.log(Status.PASS, "Successfully got the message");
			capturingScreenShot.screenShot("HomePage1");
			logger1.addScreenCaptureFromPath(capturingScreenShot.screenShot("Home page message1"));
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in getting hope page text : " + e);
			System.out.println("Exception in  homePageText method : " + e);
		}
		return text;
	}

	/*
	 * Method for clicking sign out button
	 */

	public static void clickingSignOutButton() {
		logger1.log(Status.INFO, "Clicking the Sign out link");
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.dropDowmElement));
			js.executeScript("arguments[0].click()", obj.dropDowmElement);

			wait.until(ExpectedConditions.elementToBeClickable(obj.signOutOptionElement));
			js.executeScript("arguments[0].click()", obj.signOutOptionElement);
			logger1.log(Status.PASS, "Successfully clicked the link");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the link : " + e);
			System.out.println("Exception in clickingSignOutButton method : " + e);
		}
	}

	/*
	 * Method for Entering data in search textbox
	 */

	public static void enteringSearchData(String str) {
		logger1.log(Status.INFO, "Entering search data in searchtextbox");
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.searchBoxElement));
			obj.searchBoxElement.sendKeys(str);
			logger1.log(Status.PASS, "Successfully Entered search data in searchtextbox");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in Entering search data in searchtextbox : " + e);
			System.out.println("Exception in EnteringSearchData method : " + e);
		}

	}

	/*
	 * Method for dynamically selecting data from search auto suggestions
	 */

	public static void selectingSearchData(String str) {
		logger1.log(Status.INFO, "Dynamically selecting search data from options");
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(obj.searchList));
			for (WebElement e : obj.searchList) {
				if (e.getText().contains(str)) {
					js.executeScript("arguments[0].click()", e);
					break;
				}
			}
			logger1.log(Status.PASS, "Successfully selected search data from options");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in selecting search data from options : " + e);
			System.out.println("Exception in selectingsSearchData method : " + e);
		}

	}

	/*
	 * Method for dynamically deleting data from the cart
	 */

	public static void deleteingCartData() {
		logger1.log(Status.INFO, "Dynamically deleting products from cart");
		try {

			if (obj.counterElement.isEmpty()) {

				return;
			}

			wait.until(ExpectedConditions.elementToBeClickable(obj.counterElement.getFirst()));
			obj.cartIconElement.click();

			while (true) {
				List<WebElement> cartItems = obj.cartList;

				if (cartItems.isEmpty()) {
					break;
				}

				WebElement firstItem = cartItems.get(0);
				wait.until(ExpectedConditions.visibilityOf(firstItem));
				js.executeScript("arguments[0].click()", firstItem);
				wait.until(ExpectedConditions.elementToBeClickable(obj.popUpAcceptElement));
				js.executeScript("arguments[0].click()", obj.popUpAcceptElement);
				if (cartItems.size() == 1) {
					wait.until(ExpectedConditions.elementToBeClickable(obj.closingButtonElement));
					js.executeScript("arguments[0].click()", obj.closingButtonElement);
					break;
				}
				wait.until(ExpectedConditions.stalenessOf(firstItem));
			}
			logger1.log(Status.PASS, "Successfully deleted the products from cart");

		} catch (Exception e) {
			logger1.log(Status.PASS, "Error in deleting products from cart : " + e);
			System.out.println("Exception in deleteingCartData method: " + e);
		}
	}

	/*
	 * Method for clicking proceed to cart button
	 */

	public static void clickckingProceedToCart() {
		logger1.log(Status.INFO, "Clicking proceed to cart button");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.proceedToCartElement));
			act.moveToElement(obj.proceedToCartElement).pause(Duration.ofMillis(500)).click().build().perform();
			logger1.log(Status.PASS, "Successfully clicked the button");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : " + e);
			System.out.println("Exception in clickckingProceedToCart : " + e);
		}
	}

	/*
	 * Method for clicking cartIcon
	 */

	public static void clickCartIcon() {
		logger1.log(Status.INFO, "Clicking the cart icon button");
		try {

			wait.until(ExpectedConditions.elementToBeClickable(obj.counterElement.getFirst()));
			act.moveToElement(obj.cartIconElement).click().build().perform();
			logger1.log(Status.PASS, "Successfully clicked the button");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in clicking the button : " + e);
			System.out.println("Exception in clickCartIcon method : " + e);
		}
	}

}
