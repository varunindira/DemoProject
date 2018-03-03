package com.presta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.commons.Configuration;
import com.selenium.commons.ReadExcel;

public class HomePage {

	public WebDriver driver = Configuration.browser();
	public ReadExcel read;

	@FindBy(className = "login")
	public WebElement loginLink;

	@FindBy(className = "logout")
	public WebElement logoutLink;

	@FindBy(className = "logo")
	public WebElement imageLogo;

	@FindBy(id = "search_query_top")
	public WebElement searchTextBox;

	@FindBy(name = "submit_search")
	public WebElement searchBtn;

	@FindBy(xpath = "//span[@class='big']")
	public WebElement searchResults;

	public HomePage() {
		read = new ReadExcel();
		PageFactory.initElements(driver, this);
	}

	public void loginLink() {

		loginLink.click();
		Assert.assertEquals(driver.getTitle(), read.readData("Login_Title"));

	}

	public String validateHomePage() {
		return read.readData("MyAccount_Title");
	}

	public void logout() {
		logoutLink.click();
		loginLink.click();
	}

	public void tapLogo() {
		imageLogo.click();
	}

	public void searchProduct(String prod) {

		searchTextBox.sendKeys(prod);
		searchBtn.click();
		Assert.assertEquals(searchResults.getText(), read.readData("ResultsDisplayed"));

	}

}
