package com.automation.framworks.practise.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.practise.utilities.Util;

public class TestBase {
	
	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public Properties dataprop;
	public FileInputStream ip;
	
	public TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\practise\\config\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("url"));
		
		dataprop = new Properties();
		ip = new FileInputStream("E:\\Ecliplse_AutomationWorkspace\\automation.frameworks.practise\\src\\test\\java\\com\\automation\\framworks\\practise\\TestData\\testData.properties");
		dataprop.load(ip);
		//System.out.println(dataprop.getProperty(null));
	}
	
	public WebDriver InitializeBrowserAndOpenApplication(String browserName){
		if(browserName.equals("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","disable-infobars"));
			driver = new ChromeDriver(options);
			
		}else if(browserName.equals("Firefox")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();	
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICITLY_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("url"));
		
		return driver;		
	}

}
