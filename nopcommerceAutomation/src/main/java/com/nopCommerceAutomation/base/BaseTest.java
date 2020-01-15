package com.nopCommerceAutomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public long PAGELOAD_TIMEOUT;
	public long IMPLICIT_WAIT;

	public BaseTest() {
		prop = new Properties();
		FileInputStream fis;

		try {
			fis = new FileInputStream(
					"C:\\study-java\\com.bank\\src\\main\\java\\com\\onlineBanking\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialization() {
		logger = Logger.getLogger(BaseTest.class.getName());
		PropertyConfigurator.configure(
				"C:\\study-java\\com.bank\\src\\main\\java\\com\\onlineBanking\\config\\logforj.properties");

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			logger.info("opening safari browser"); // logging information
			driver = new SafariDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		logger.info("navigating to the " + prop.getProperty("url"));
		driver.get(prop.getProperty("url"));

	}

}
