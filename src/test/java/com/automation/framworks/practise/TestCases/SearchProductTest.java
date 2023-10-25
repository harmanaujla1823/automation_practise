package com.automation.framworks.practise.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.framworks.practise.Pages.LandingPage;
import com.automation.framworks.practise.Pages.SearchPage;
import com.automation.framworks.practise.TestBase.TestBase;

public class SearchProductTest extends TestBase {
	
	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void searchProductSetup() {
		
		driver = InitializeBrowserAndOpenApplication(prop.getProperty("browserf"));		
	}
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("validProduct"));
		//landingpage.enterProductName(dataprop.getProperty("validProduct"));
		//searchpage = landingpage.clickOnSearchBox();
		
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataprop.getProperty("validProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.validProductDisplayStatus());
		//Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed());
				
	}
	
	@Test(priority = 2)
	public void verifySearchWithInalidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("invalidProduct"));
		//landingpage.clickOnSearchBox();
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataprop.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		searchpage = new SearchPage(driver);
		Assert.assertFalse(searchpage.invalidOrNoProductDisplayStatus());
		//Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).isDisplayed());		
		
				
	}
	
	@Test(priority = 3, dependsOnMethods = "verifySearchWithInalidProduct")
	public void verifySearchWithNoProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.clickOnSearchBox();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		//searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.invalidOrNoProductDisplayStatus());
		//Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).isDisplayed());
		
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
