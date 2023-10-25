package com.automation.framworks.practise.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.framworks.practise.Pages.AccountSuccessPage;
import com.automation.framworks.practise.Pages.LandingPage;
import com.automation.framworks.practise.Pages.RegisterPage;
import com.automation.framworks.practise.TestBase.TestBase;
import com.qa.practise.utilities.Util;

public class RegisterTest extends TestBase{
	public RegisterTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public RegisterPage registerpage; 
	public LandingPage landingpage; 
	public AccountSuccessPage accountsuccesspage;
	
	@BeforeMethod
	public void registerSetup(){
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserf"));
		//WebDriver driver = new ChromeDriver();
		landingpage = new LandingPage(driver);
		//landingpage.clickOnMyAccount();
		//landingpage.selectRegisterOption();
		registerpage = landingpage.navigateToRegisterPage();
		//registerpage = landingpage.selectRegisterOption();
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Register")).click();
	}
	
	@Test(priority = 1)
	public void verifyRegisterWithMandatoryDetails() {
		
		accountsuccesspage = registerpage.registerPageMandatoryDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				Util.emailWithDateTimeStamp(), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		//RegisterPage registerpage = new RegisterPage(driver);
		//registerpage.enterFirstName(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//registerpage.enterLastName(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//registerpage.enterEmail(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//registerpage.enterTelephone(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//registerpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.clickOnPrivacyPolicyChechbox();
		//driver.findElement(By.xpath("//input[@name = 'agree'  and @value='1']")).click();
		//registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//String actualSuccessMessage = registerpage.retreiveActualSuccessMessageText();
		//String actualSuccessMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
		//String expectedSuccessMessage = dataprop.getProperty("registerAccountSuccessMessage");
		
		//AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		
		Assert.assertTrue(accountsuccesspage.accountCreatedSuccessMessageTeXt());	
	}
	
	@Test(priority = 2)
	public void verifyRegisterWithAllDetails() {
		accountsuccesspage = registerpage.registerPageAllDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				Util.emailWithDateTimeStamp(), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		//RegisterPage registerpage = new RegisterPage(driver);
		//registerpage.enterFirstName(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//registerpage.enterLastName(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//registerpage.enterEmail(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//registerpage.enterTelephone(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//registerpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.clickOnPrivacyPolicyChechbox();
		//driver.findElement(By.xpath("//input[@name = 'agree'  and @value='1']")).click();
		//registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//String actualSuccessMessage = registerpage.retreiveActualSuccessMessageText();
		//String actualSuccessMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
		//String expectedSuccessMessage = dataprop.getProperty("registerAccountSuccessMessage");
		Assert.assertTrue(registerpage.retreiveActualSuccessMessageText().contains(dataprop.getProperty("registerAccountSuccessMessage")));
	}
	
	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {
		
		registerpage.registerPageWithExistingEmail(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				prop.getProperty("validEmail"), dataprop.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		//RegisterPage registerpage = new RegisterPage(driver);
		//registerpage.enterFirstName(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//registerpage.enterLastName(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//registerpage.enterEmail(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//registerpage.enterTelephone(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//registerpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//registerpage.clickOnPrivacyPolicyChechbox();
		//driver.findElement(By.xpath("//input[@name = 'agree'  and @value='1']")).click();
		//registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//String actualSuccessMessage = registerpage.retreiveEmailAlreadyExistWarningMessageText();
		//String actualSuccessMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText();
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys("validPassword");
		//driver.findElement(By.xpath("//input[@name = 'agree'  and @value='1']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//String actualSuccessMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//String expectedSuccessMessage = dataprop.getProperty("emailExistWarningMessage");
		Assert.assertTrue(registerpage.retreiveEmailAlreadyExistWarningMessageText().contains(dataprop.getProperty("emailExistWarningMessage")));
	}
	
	
	@Test(priority = 4)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.retreiveAllWarningMesseges(dataprop.getProperty("policyWarningMessage"), (dataprop.getProperty("firstNameWarningMessage")),
				(dataprop.getProperty("lastNameWarningMessage")), (dataprop.getProperty("emailWarningMessage")), (dataprop.getProperty("telephoneWarningMessage")), 
				(dataprop.getProperty("passwordWarningMessage"))));
		
		
		//registerpage = new RegisterPage(driver);
		//registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//String actualPrivacuPolicyWarningMessage = registerpage.retreivePrivacyPolicyWarningMessageText();
		//String actualPrivacuPolicyWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//String expectedPrivacuPolicyWarningMessage = dataprop.getProperty("policyWarningMessage");
		//Assert.assertTrue(registerpage.retreivePrivacyPolicyWarningMessageText().contains(dataprop.getProperty("policyWarningMessage")));
		
		//String actualFirstNameWarningsMessage = registerpage.retreiveFirstNameWarningsMessageText();
		//String actualFirstNameWarningsMessage = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		//String expectedFirstNameWarningsMessage = dataprop.getProperty("firstNameWarningMessage");
		//Assert.assertTrue(registerpage.retreiveFirstNameWarningsMessageText().contains(dataprop.getProperty("firstNameWarningMessage")));
				
		//String actualLastNameWarningsMessage = registerpage.retreiveLastNameWarningsMessageText();
		//String actualLastNameWarningsMessage = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		//String expectedLastNameWarningsMessage = dataprop.getProperty("lastNameWarningMessage");
		//Assert.assertTrue(registerpage.retreiveLastNameWarningsMessageText().contains(dataprop.getProperty("lastNameWarningMessage")));
				
		//String actualEmailWarningsMessage = registerpage.retreiveEmailWarningsMessageText();
		//String actualEmailWarningsMessage = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		//String expectedEmailWarningsMessage = dataprop.getProperty("emailWarningMessage");
		//Assert.assertTrue(registerpage.retreiveEmailWarningsMessageText().contains(dataprop.getProperty("emailWarningMessage")));
			
		//String actualTelephoneWarningsMessage = registerpage.retreiveTelephoneWarningsMessageText();
		//String actualTelephoneWarningsMessage = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		//String expectedTelephoneWarningsMessage = dataprop.getProperty("telephoneWarningMessage");
		//Assert.assertTrue(registerpage.retreiveTelephoneWarningsMessageText().contains(dataprop.getProperty("telephoneWarningMessage")));
	
		//String actualPasswordWarningsMessage = registerpage.retreivePasswordWarningsMessageText();
		//String actualPasswordWarningsMessage = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		//String expectedPasswordWarningsMessage = dataprop.getProperty("passwordWarningMessage");
		//Assert.assertTrue(registerpage.retreivePasswordWarningsMessageText().contains(dataprop.getProperty("passwordWarningMessage")));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
