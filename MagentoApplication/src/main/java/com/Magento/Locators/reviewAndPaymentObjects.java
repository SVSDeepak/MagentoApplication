package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class reviewAndPaymentObjects extends Browser{
	

	public reviewAndPaymentObjects() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = " //button[@class='action primary checkout']  ")
	public WebElement placeOrderButtonElement;
	
	@FindBy(xpath = " //h1[@class='page-title']/span ")
	public WebElement thankYouMessageElement;
	

}
