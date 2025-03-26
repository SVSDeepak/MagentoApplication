package com.Magento.Locators;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Magento.Browser.Browser;

public class shoppingCartPage extends Browser{
	
	public shoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = " //table[@id='shopping-cart-table']/tbody[1]//strong/a")
	public WebElement product1TextElement;
	
	@FindBy(xpath = " //table[@id='shopping-cart-table']/tbody[2]//strong/a")
	public WebElement product2TextElement;

	@FindBy(xpath = " //td[@data-th='Order Total']//span[@class='price']   ")
	public WebElement costTextElement;
	
	

}
