package com.Magento.Locators;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class homePageObjects extends Browser {

	public homePageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='panel wrapper']//ul[@class='header links']/li[2]/a")
	public WebElement signInLink;

	@FindBy(xpath = "//div[@class='panel wrapper']//ul[@class='header links']/li[3]/a ")
	public WebElement createNewAccountLink;

	@FindBy(xpath = "//span[text()='Home Page'] ")
	public WebElement homePagetext;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	public WebElement dropDowmElement;

	@FindBy(xpath = "//ul[@class='header links']/li[3]/a[contains(text(),'Sign Out')]  ")
	public WebElement signOutOptionElement;

	@FindBy(xpath = "//input[@id='search']  ")
	public WebElement searchBoxElement;
	
	@FindAll(@FindBy(xpath = "//ul[@role='listbox']/li "))
	public List<WebElement> searchList;
	
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a  ")
	public WebElement cartIconElement;
	
	@FindAll(@FindBy(xpath = "//a[@title='Remove item'] "))
	public List<WebElement> cartList;
	
	 
	@FindBy(xpath = "//button[@class='action-primary action-accept'] ")
	public WebElement popUpAcceptElement;
	
	@FindAll(@FindBy(xpath="//span[@class='counter qty'] /span[@class='counter-number']  "))
	public List<WebElement> counterElement;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout'] ")
	public WebElement proceedToCartElement;
	
	  
	
	@FindBy(xpath="//button[@data-action='close'] ")
	public WebElement closingButtonElement;
	
}
