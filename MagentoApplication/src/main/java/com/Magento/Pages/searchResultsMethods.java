package com.Magento.Pages;

import org.openqa.selenium.WebElement;
import com.Magento.Browser.Browser;
import com.Magento.Locators.searchResults;
import com.aventstack.extentreports.Status;

public class searchResultsMethods extends Browser {

	/*
	 * Necessary objects declared globally
	 */

	static searchResults obj;

	/*
	 * Method for dynamically selecting data from search auto suggestions
	 */

	public static void selectingSearchData(String str) {
		logger1.log(Status.INFO, "Selecting the product dynamically");
		obj = new searchResults();

		try {

			boolean check = true;
			do {
				for (WebElement e : obj.productList) {
					if (e.getText().contains(str)) {
						js.executeScript("arguments[0].scrollIntoView();", e);
						js.executeScript("arguments[0].click()", e);
						check = false;
						break;
					}
				}
					if (check)
					{
						js.executeScript("arguments[0].scrollIntoView();", obj.nextElement);
						js.executeScript("arguments[0].click()", obj.nextElement);
					}
			} while (check);
			logger1.log(Status.PASS, "Successfully selected the product ");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error in selecting the product : "+e);
			System.out.println("Exception in selectingsSearchData method : " + e);
		}

	}

}
