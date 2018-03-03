package com.presta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.commons.Configuration;

public class LoginPage {

	public WebDriver driver = Configuration.browser();

	@FindBy(id = "email")
	public WebElement emailTextBox;

	@FindBy(id = "passwd")
	public WebElement passwordText;

	@FindBy(id = "SubmitLogin")
	public WebElement loginBtn;

	@FindBy(xpath = "//li[text()='Invalid e-mail address']")
	public WebElement errorText;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginToAPP(String userName, String password) {
		emailTextBox.clear();
		emailTextBox.sendKeys(userName);
		passwordText.clear();
		passwordText.sendKeys(password);
		loginBtn.click();

	}

	public void errorMessage() {

		Assert.assertTrue(errorText.isDisplayed(), "error message not displayed");
		
	}

}
