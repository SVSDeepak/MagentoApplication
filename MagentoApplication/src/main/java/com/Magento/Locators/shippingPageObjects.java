package com.Magento.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class shippingPageObjects extends Browser{
	
	public shippingPageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //input[@name='firstname']  ")
	public WebElement firstNameElement;
	
	@FindBy(xpath = "//input[@name='lastname']   ")
	public WebElement lastNameElement;
	
	@FindBy(xpath = "//input[@name='street[0]']   ")
	public WebElement streetAdressElement;
	
	@FindBy(xpath = " //input[@name='city'] ")
	public WebElement cityElement;
	
	@FindBy(xpath = "//select[@name='region_id']   ")
	public WebElement stateElement;
	
	@FindBy(xpath = "//input[@name='postcode']  ")
	public WebElement zipElement;
	
	@FindBy(xpath = " //select[@name='country_id']   ")
	public WebElement countryElement;
	
	@FindBy(xpath = " //input[@name='telephone']  ")
	public WebElement phoneNumberElement;
	
	@FindBy(xpath = "//table[@class='table-checkout-shipping-method']/tbody/tr[1]/td/input ")
	public WebElement shippingMethodsElement;
	
	@FindBy(xpath = "//button[@class='button action continue primary']   ")
	public WebElement nextpageElement;
	
	@FindBy(xpath = "//div[@class='message warning']/span   ")
	public WebElement errorMessageTextElement;
	
	@FindBy(xpath= "//button[@class='action action-show-popup']  ")
	public WebElement addressButtonElement;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement saveAddressCheckBoxButton;
	
	@FindBy(xpath="//button[@class='action primary action-save-address'] ")
	public WebElement shipHereButtonElement;
	

}
