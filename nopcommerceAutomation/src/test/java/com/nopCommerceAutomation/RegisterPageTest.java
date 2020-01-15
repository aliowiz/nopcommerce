package com.nopCommerceAutomation;

import org.testng.annotations.BeforeMethod;

import com.nopCommerceAutomation.base.BaseTest;
import com.nopCommerceAutomation.page.HomePage;
import com.nopCommerceAutomation.page.LoginPage;
import com.nopCommerceAutomation.page.RegisterPage;
import com.nopCommerceAutomation.page.ShopingCartPage;
import com.nopCommerceAutomation.page.WishListPage;

public class RegisterPageTest extends BaseTest{
	
	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	WishListPage wishlistPage;
	ShopingCartPage shoppingCartPage;
	String sheetName = "user";
	
	public RegisterPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		wishlistPage = new WishListPage();
		shoppingCartPage = new ShopingCartPage();
	}

}
