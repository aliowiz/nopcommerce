package com.nopCommerceAutomation;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceAutomation.base.BaseTest;
import com.nopCommerceAutomation.page.HomePage;
import com.nopCommerceAutomation.page.LoginPage;
import com.nopCommerceAutomation.page.RegisterPage;
import com.nopCommerceAutomation.page.ShopingCartPage;
import com.nopCommerceAutomation.page.WishListPage;
import com.nopCommerceAutomation.util.TestUtil;

public class LoginPageTest extends BaseTest{
	
	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	WishListPage wishlistPage;
	ShopingCartPage shoppingCartPage;
	String sheetName = "user";
	
	public LoginPageTest() {
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
	
	@Test(priority = 1)
	public void userTryLoginWithoutUseNameAndPasswordTest() throws Exception {
		homePage.goToLoinPage();
		Thread.sleep(2000);
		loginPage.clickOnLoginButton();
		String loginError = loginPage.getEmailErrorMessage();
		Assert.assertEquals(loginError, "Please enter your email");
	}
	
	@Test(priority = 2)
	public void verifyLoginErrorMessageTest() throws Exception {
		homePage.goToLoinPage();
		Thread.sleep(2000);
		loginPage.enterUserName(prop.getProperty("email"));
		loginPage.clickOnLoginButton();
		String loginFailError = loginPage.getLoginErrorMessage();
		Assert.assertTrue(loginFailError.contains("Login was unsuccessful."));
	}
	
	
	//this test will use test data that provided by dataprovidor method
	@Test(priority = 3, dataProvider = "getRegisteredUserData")
	public void validUserLoginSuccessTest(String userName, String userPassword) throws InterruptedException {
		homePage.goToLoinPage();
		Thread.sleep(2000);
		loginPage.login(userName, userPassword);
		Assert.assertTrue(homePage.myAccountLink());
	}
	
	// TestNG data provider feature will provide data to test that connected to the data providor
	@DataProvider
	public Object[][] getRegisteredUserData(){
		//calling getTestData method from TestUtil class
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
