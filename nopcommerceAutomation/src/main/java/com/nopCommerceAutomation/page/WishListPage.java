package com.nopCommerceAutomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceAutomation.base.BaseTest;

public class WishListPage extends BaseTest {
	
	
	@FindBy(how=How.XPATH,using="//div[@class='page-title']")
	WebElement wishlistPageTitle;
	
	public WishListPage() {
		PageFactory.initElements(driver, this);
	}

	public String getWishlistPageTitle() {
		return wishlistPageTitle.getText();
	}
	
}

