package com.nopCommerceAutomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceAutomation.base.BaseTest;

public class ShopingCartPage extends BaseTest {

	@FindBy(how=How.XPATH,using="//span[@class='cart-label']")
	WebElement shoppingCartPageTitle;
	
	public ShopingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getShoppingCartPageTitle() {
		return shoppingCartPageTitle.getText();
	}

}
