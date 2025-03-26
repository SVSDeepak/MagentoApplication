package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class signOutPage extends Browser{
	
	public signOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'You are signed out')] ")
	public WebElement signOutTextElement;

}
