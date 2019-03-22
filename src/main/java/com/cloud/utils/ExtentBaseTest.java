package com.cloud.utils;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentBaseTest {
	
	private static ExtentHtmlReporter htmlreporter;
	private static ExtentTest test;
	private static ExtentReports extent;
	private static String filepath;
	
	
	public static ExtentReports getExtent()
	{

			extent=new ExtentReports();
			extent.attachReporter(getHtmlReporter());	
		
			return extent;
	}
	
	public static ExtentHtmlReporter getHtmlReporter()
	{
		htmlreporter=new ExtentHtmlReporter(getFilePath());
		htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setDocumentTitle("Rebill_Application_Reports");
		htmlreporter.config().setReportName("Rebill_Application Test Reports");
		htmlreporter.config().setTheme(Theme.DARK);	
		return htmlreporter;
	}
	
	public static void setFilePath(String filepath)
	{
		ExtentBaseTest.filepath=filepath;
	}
	
	public static String getFilePath()
	{
		
		return filepath;
	}
	
	public static ExtentTest createTest(String testname,String description)
	{
		 test=extent.createTest(testname, description);
		 
		 return test;
	}
	
	public static ExtentTest getResult(ITestResult result,String Testmessage)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test=test.pass(Testmessage+" is Successful");
			
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test=test.fail(Testmessage+" is Failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test=test.fail(Testmessage+" is Skipped");
		}
		
		return test;
	}
	

}
