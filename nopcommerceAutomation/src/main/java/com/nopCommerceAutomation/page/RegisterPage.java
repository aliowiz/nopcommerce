package com.nopCommerceAutomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceAutomation.base.BaseTest;

public class RegisterPage extends BaseTest {
	@FindBy(how=How.XPATH,using="//div[@class='page-title']")
	WebElement registerPageTitle;
	
	
	public RegisterPage() {
		PageFactory.initElements(driver,this);
		
	}
	public String verifyRegisterPageTitle() {
		
		return registerPageTitle.getText();
	}

}
