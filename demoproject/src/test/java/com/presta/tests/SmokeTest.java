package com.presta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.presta.pages.HomePage;
import com.presta.pages.LoginPage;
import com.selenium.commons.Configuration;
import com.selenium.commons.ReadExcel;

public class SmokeTest {

	public WebDriver driver = Configuration.browser();
	public HomePage home;
	public LoginPage login;
	public ReadExcel read;

	public SmokeTest() {
		home = new HomePage();
		login = new LoginPage();
		read = new ReadExcel();

	}

	@BeforeSuite(alwaysRun = true)
	public void loginToApp() {
		driver.get(Configuration.URL);
		driver.manage().window().maximize();
		home.loginLink();
		login.loginToAPP(Configuration.username, Configuration.password);
		Assert.assertEquals(driver.getTitle(), home.validateHomePage());

	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void navigateToHome() {
		home.tapLogo();
	}

	@Test(testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			"sanity", "1" })
	public void alogin_Positive() {
		Assert.assertTrue(true);

	}

	@Test(testName = "LoginNegative", description = "LoginNegative", timeOut = 190000, enabled = true, groups = {
			"sanity", "2" })
	public void loginNegative() {

		home.logout();
		login.loginToAPP("dsfsd", "sdfsdf");
		login.errorMessage();
		login.loginToAPP(Configuration.username, Configuration.password);
		Assert.assertEquals(driver.getTitle(), home.validateHomePage());
	}

	@Test(testName = "searchProduct", description = "searchProduct", timeOut = 190000, enabled = true, groups = {
			"sanity", "3" })
	public void searchProduct() {
		home.searchProduct(read.readData("Product_ipod"));

	}

}
