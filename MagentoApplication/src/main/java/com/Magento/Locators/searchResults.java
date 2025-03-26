package com.Magento.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class searchResults extends Browser{
	
	public searchResults() {
		PageFactory.initElements(driver, this);
	}

	public By products = By.xpath(" //div[@class='product details product-item-details']/strong/a ");
	
	public By next = By.xpath(" //div[@class='products wrapper grid products-grid']/following::div/div[2]/ul[1]/li[@class='item pages-item-next']/a ");
	
	
	

	@FindAll(@FindBy(xpath = " //div[@class='product details product-item-details']/strong/a"))
	public List<WebElement> productList;
	
	@FindBy(xpath = "//div[@class='products wrapper grid products-grid']/following::div/div[2]/ul[1]/li[@class='item pages-item-next']/a ")
	public WebElement nextElement;

}
