package com.nopCommerceAutomation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerceAutomation.base.BaseTest;

public class HomePage extends BaseTest {
	/*
	 * @FindBy(xpath = "//img[@alt='nopCommerce demo store']") WebElement pageLogo;
	 */

	@FindBy(how = How.XPATH, using = "//img[@alt='nopCommerce demo store']")
	WebElement pageLogo;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Register')]")
	WebElement registerLink;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//span[@class='wishlist-label'][contains(.,'Wishlist')]")
	WebElement wishListLink;
	
	@FindBy(how=How.XPATH,using="")
	WebElement myAccountLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String veiryPageTitle() {
		return driver.getTitle();
	}
	public boolean verifyLogo() {
		return pageLogo.isDisplayed();
	}

	public RegisterPage goToRegisterPage() {
		registerLink.click();
		return new RegisterPage();

	}
	public LoginPage goToLoinPage() {
		loginLink.click();
		return new LoginPage();
		
	}
	public WishListPage goToWishListPage() {
		 wishListLink.click();
		 return new WishListPage();
	}
	
	public boolean myAccountLink() {
		return myAccountLink.isDisplayed();
	}

	public void goToShoppingCartPage() {
		// TODO Auto-generated method stub
		
	}
}
