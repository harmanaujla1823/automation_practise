package com.automation.framworks.practise.TestCases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.framworks.practise.Pages.AccountPage;
import com.automation.framworks.practise.Pages.LandingPage;
import com.automation.framworks.practise.Pages.LoginPage;
import com.automation.framworks.practise.TestBase.TestBase;
import com.automation.framworks.practise.TestData.ExcelCode;
import com.qa.practise.utilities.Util;

public class LoginTest extends TestBase {
	
	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver; 
	public LandingPage landingpage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	
	@BeforeMethod
	public void loginSetup() {
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserf"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccount();
		//landingpage.selectLoginOption();
		loginpage = landingpage.selectLoginOption();
				
		//WebDriver driver = new ChromeDriver();
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Login")).click();
	}
	
	@Test(priority=1, dataProvider = "TN", dataProviderClass = ExcelCode.class )
	public void verifyLoginWithValidLoginCredentials(String email,String password ) {
		
		//loginpage = new LoginPage(driver);
		accountpage = loginpage.navigateToAccountPage(email, password);
		//loginpage.enterEmail(email);
		//loginpage.enterPassword(password);
		//loginpage.clickOnLoginButton();
		//accountpage = loginpage.clickOnLoginButton();
		//driver.findElement(By.id("input-email")).sendKeys(email);
		//driver.findElement(By.id("input-password")).sendKeys(password);
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.validateEditYourAccountInformationLinkDisplayStatus());
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		
		//loginpage = new LoginPage(driver);
		loginpage.navigateToAccountPage(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		//loginpage.enterEmail(prop.getProperty("validEmail"));
		//loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//String actualWarningMessage = loginpage.retreiveTextOfloginWarningMessage();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	//	String expectedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		//loginpage = new LoginPage(driver);
		
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		//loginpage.enterEmail(Util.emailWithDateTimeStamp());
		//loginpage.enterPassword(prop.getProperty("validPassword"));
		//loginpage.clickOnLoginButton();
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	//	String actualWarningMessage = loginpage.retreiveTextOfloginWarningMessage();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	//	String expectedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
		//loginpage = new LoginPage(driver);
		loginpage.navigateToAccountPage(Util.emailWithDateTimeStamp(), dataprop.getProperty("invalidPassword"));
		//loginpage.enterEmail(Util.emailWithDateTimeStamp());
		//loginpage.enterPassword(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//String actualWarningMessage = loginpage.retreiveTextOfloginWarningMessage();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//String expectedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		//loginpage = new LoginPage(driver);
		
		loginpage.clickOnLoginButton();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//String actualWarningMessage = loginpage.retreiveTextOfloginWarningMessage();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	//	String expectedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retreiveTextOfloginWarningMessage().contains(dataprop.getProperty("loginWarningMessage")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
