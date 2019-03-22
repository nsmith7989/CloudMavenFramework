package com.cloud;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.cloud.driver.WebDriverType;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.utils.ExcelUtil;
import com.cloud.utils.PropertiesReader;
import com.cloud.utils.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class BaseWebTest extends BaseTest{
    public WebDriver driver;
    protected String devicemode;
    protected ThreadLocal<WebDriver> threadDriver = null;
    public static Properties envproperties;
	public static ExcelUtil excel;
	
	@BeforeMethod(alwaysRun = true)
	//@BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) throws IOException {
	//public void setup(String browser) throws IOException {
       	
    	envproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+envproperties.getProperty("cloud.excel.path_HCM"));
		System.out.println("INTEND TO READ THE ENVIRONMENT DETAILS FROM EXCEL WORKBOOK");
		String environementType=excel.getCellData("Environment_Setup", 1, 0);
    	 try {

        	threadDriver = new ThreadLocal<WebDriver>();
        	switch (browser)
        	{
        		case "chrome":
	        					driver=WebDriverTest.initializeDriver(WebDriverType.chrome);
	        					driver.manage().window().maximize();
				                break;
	        	case "firefox":
	        		 			driver=WebDriverTest.initializeDriver(WebDriverType.firefox);
				                break;
	        	case "ie":
	        		 			driver=WebDriverTest.initializeDriver(WebDriverType.ie);
	        		 			driver.manage().window().maximize();
	        					break;
	        	default:
	        					driver=WebDriverTest.initializeDriver(WebDriverType.chrome);
	        					driver.manage().window().maximize();
	        					break;
        	}
        	
//        	driver.manage().window().maximize();
        	
          if(environementType.equalsIgnoreCase("test"))
          	{
          		driver.get(context.getEnvironmentsProperty("testURL"));
          	}
        	else if(environementType.equalsIgnoreCase("dev"))
        	{
        		driver.get(context.getEnvironmentsProperty("devURL"));
        	}

        } catch (Exception e) {
            if (driver != null) {
                driver.quit();
            }
        }
    }
	
    public WebDriver getDriver() {
		return threadDriver.get();
	}
    
 
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) {
   	   	if(result.getStatus() != ITestResult.SUCCESS){
	    	report.log(LogStatus.INFO, "Test Failed, Something wrong in here." + report.addScreenCapture(Screenshot.takeScreenshotX(driver, result.getMethod().getMethodName(), context)));
   	   	}
   	   	driver.quit();
    }
	

	
}
