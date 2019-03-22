package com.cloud.driver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverUtil {
	
	public static DesiredCapabilities caps;

	
	public static void initializeInternetExplorer()
	{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
			caps = new DesiredCapabilities();
			caps.setCapability(InternetExplorerDriver.SILENT,true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setBrowserName("IE");
			new InternetExplorerOptions(caps);
	}
	
	public static void initializeChrome()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	}
	
	public static void initializeFirefox()
	{	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
	}
	 

}
