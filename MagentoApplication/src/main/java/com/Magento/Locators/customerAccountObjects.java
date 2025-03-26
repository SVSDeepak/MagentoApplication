package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class customerAccountObjects extends Browser {

	public customerAccountObjects() {

		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@id='firstname']")
	public WebElement firstNameElement;

	@FindBy(xpath = "//input[@id='lastname'] ")
	public WebElement lastnameElement;

	@FindBy(xpath = "//input[@id='email_address']   ")
	public WebElement emailElement;

	@FindBy(xpath = "//input[@id='password']  ")
	public WebElement passwordElement;

	@FindBy(xpath = "//input[@id='password-confirmation']    ")
	public WebElement confirmPasswordElement;

	@FindBy(xpath = "//button[@title='Create an Account']    ")
	public WebElement createAnAccountElement;

	@FindBy(xpath = "//div[@id='email_address-error']  ")
	public WebElement errorElement;
}
