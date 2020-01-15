package com.nopCommerceAutomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceAutomation.base.BaseTest;

public class LoginPage extends BaseTest{
	@FindBy(how=How.XPATH,using="//div[@class='page-title']")
	WebElement loginPageWelcomeMessage;
	
	
	@FindBy(how=How.XPATH, using="//input[@value='Log in']")
	WebElement logninBtn;
	
	@FindBy(how=How.XPATH, using="//span[@id='Email-error']")
	WebElement emailErrorMessage;
	
	@FindBy(how=How.XPATH, using="//div[@class='message-error validation-summary-errors']")
	WebElement loginErrorMessage;
	
	@FindBy(how=How.XPATH, using="//input[@id='Email']")
	WebElement email;
	
	@FindBy(how=How.XPATH, using="//input[@id='Password']")
	WebElement password;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageWelcomeMessage() {
		return loginPageWelcomeMessage.getText();
	}
	
	public void clickOnLoginButton() {
		logninBtn.click();
	}
	
	public String getEmailErrorMessage() {
		return emailErrorMessage.getText();
	}
	
	public String getLoginErrorMessage() {
		return loginErrorMessage.getText();
	}
	
	public void enterUserName(String userName) {
		email.sendKeys(userName);
	}
	
	public void enterPasswoed(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public HomePage login(String userName, String userPassword) {
		email.sendKeys(userName);
		password.sendKeys(userPassword);
		logninBtn.click();
		return new HomePage();
	}}