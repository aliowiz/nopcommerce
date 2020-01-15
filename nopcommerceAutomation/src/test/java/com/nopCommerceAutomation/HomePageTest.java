package com.nopCommerceAutomation;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceAutomation.base.BaseTest;
import com.nopCommerceAutomation.page.HomePage;
import com.nopCommerceAutomation.page.LoginPage;
import com.nopCommerceAutomation.page.RegisterPage;
import com.nopCommerceAutomation.page.ShopingCartPage;
import com.nopCommerceAutomation.page.WishListPage;

public class HomePageTest extends BaseTest {

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	WishListPage wishListPage;
	ShopingCartPage shoppingCartPage;
	
	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		wishListPage = new WishListPage();
		shoppingCartPage = new ShopingCartPage();
		logger = Logger.getLogger(HomePageTest.class.getName());
		
	}
	

	@Test(priority = 1)
	public void verifyPageTitleTest() {
		logger.info("verify page title test started");
		String title = homePage.veiryPageTitle();
		Assert.assertEquals(title, "nopCommerce demo store");
		logger.info("verify page title test completed");
	}

	@Test(priority = 2)
	public void verifyLogo() {
		logger.info("verify logo test started");
		boolean status = homePage.verifyLogo();
		Assert.assertTrue(status);
		logger.info("verify logo test completed");

	}

	@Test(priority = 3)
	public void goToRegisterPage() {
		logger.info("validate register page link test started");
		homePage.goToRegisterPage();
		logger.info("navigating to register page");
		String registerPageTitle = registerPage.verifyRegisterPageTitle();
		Assert.assertEquals(registerPageTitle, "Register");
		logger.info("register page test completed");
	}
	@Test(priority = 4)
	public void goToLoginPage() {
		homePage.goToLoinPage();
		String loginPageText = loginPage.getLoginPageWelcomeMessage();
		Assert.assertEquals(loginPageText, "Welcome, Please Sign In!");
		
		
	}
	@Test(priority = 5)
	public void goToWishListPage() {
		homePage.goToWishListPage();
		String wishlistPageTitle = wishListPage.getWishlistPageTitle();
		Assert.assertEquals(wishlistPageTitle, "Wishlist");
	}
	@Test(priority = 6)
	public void goToShoppingCartPage() {
		homePage.goToShoppingCartPage();
		String shoppingCartPageTiel = shoppingCartPage.getShoppingCartPageTitle();
		Assert.assertEquals(shoppingCartPageTiel, "Shopping cart");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
