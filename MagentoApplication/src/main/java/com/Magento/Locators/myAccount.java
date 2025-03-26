package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class myAccount extends Browser {
	
	public myAccount() {
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']  ")
	public WebElement myAccountTextElement;
	
	
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	public WebElement registrationtextElement;
	
	
}
