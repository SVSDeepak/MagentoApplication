package com.Magento.Locators;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class addToCartPage extends Browser{
	
	public addToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='swatch-attribute color']/div/div "))
	public List<WebElement> colourList;
	
	@FindAll(@FindBy(xpath = " //div[@attribute-code=\"size\"]/div/div "))
	public List<WebElement> sizeList;

	@FindBy(xpath = " //input[@class='input-text qty']  ")
	public WebElement quantityElement;
	
	@FindBy(xpath = " //button[@title='Add to Cart'] ")
	public WebElement addTocartButtonElement;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']  ")
	public WebElement conformationMessageElement;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']/a")
	public WebElement shoppingCartElement;

}
