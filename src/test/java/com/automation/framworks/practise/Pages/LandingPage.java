package com.automation.framworks.practise.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountDropDown;
	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, LandingPage.class);
	}
	
	public void clickOnMyAccount() {
		MyAccountDropDown.click();
	}
	
	public LoginPage selectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		MyAccountDropDown.click();
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductName(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public SearchPage clickOnSearchBox() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage navigateToSearchPage(String productName) {
		searchBox.sendKeys(productName);
		searchButton.click();
		return new SearchPage(driver);
		
		
		
	}

}
