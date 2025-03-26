package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class signInObjects extends Browser {

	public signInObjects() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@id='email'] ")
	public WebElement emailElement;

	@FindBy(xpath = "//input[@name='login[password]'] ")
	public WebElement passwordElement;

	@FindBy(xpath = "//button[@class='action login primary'] ")
	public WebElement signInElement;

	@FindBy(xpath = " //div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']  ")
	public WebElement errorElement;

}
