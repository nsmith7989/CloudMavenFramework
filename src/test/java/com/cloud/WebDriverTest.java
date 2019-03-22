package com.cloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cloud.driver.WebDriverType;
import com.cloud.driver.WebDriverUtil;

public class WebDriverTest extends BaseWebTest{
	
	public WebDriverType drivertype;
	public WebDriver driver;
	
	@SuppressWarnings("unchecked")
	public static <T extends WebDriver> T initializeDriver(WebDriverType drivertype)
	{
		T driver=null;
				
      	switch (drivertype)
    	{

        	case chrome:
        		 			WebDriverUtil.initializeChrome();
        		 			ChromeOptions options = new ChromeOptions();
        		 			options.addArguments("disable-infobars");
        		 			driver=(T) new ChromeDriver(options);
			                break;
        	case firefox:
        					WebDriverUtil.initializeFirefox();
			        		driver = (T) new FirefoxDriver();
			                break;
        	case ie:
        					WebDriverUtil.initializeInternetExplorer();
        				    driver = (T) new InternetExplorerDriver();
        					break;
        	default:
        					WebDriverUtil.initializeChrome();
        					driver =  (T) new ChromeDriver();
        					break;
    	}
      	
      	return  driver;
			
				
	}

}
