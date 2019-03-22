package com.cloud.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;

import com.cloud.models.DataHolder;
import com.cloud.properties.ExecutionContext;
import org.joda.time.format.DateTimeFormat;

public class Screenshot1{
	private final static String defaultReportPath = "report";
	
    public static String takeScreenshotX(WebDriver driver, String ssTitle, ExecutionContext context, ITestNGMethod method) {
    	if (ssTitle == null) ssTitle = "";
    	String fileName = null;

        String reportPath = context.getSettingsParameter("reportDir");
        if (reportPath == null || reportPath.trim().isEmpty()) {
            reportPath = defaultReportPath;
        }

        String screenshotsDir = context.getSettingsParameter("screenshotsDir");
        if(method.getMethodName().toString().contains("_iSS_")){
        	screenshotsDir=screenshotsDir+"iOS/";       	
        }
        else
        {
        	screenshotsDir=screenshotsDir+"Android/";
        }
    	try {
    		String savingDir = reportPath + FileSystems.getDefault().getSeparator() + screenshotsDir; 
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            fileName = method.getMethodName().toString()+"_"+ ssTitle + "_"  
                    + DateTimeFormat.forPattern("MMddyyyy_HHmmss").print(new DateTime()) + ".png";
            File targetFile = new File(savingDir + fileName);
            FileUtils.copyFile(sourceFile, targetFile);
    	} catch(IOException e){}    	
        return screenshotsDir + fileName;
    }
    
    public static String takeScreenshotX(WebDriver driver, String ssTitle, ExecutionContext context) {
    	System.out.println("title of report is "+ ssTitle);
    	if (ssTitle == null) ssTitle = "";
    	String fileName = null;
        String reportPath = context.getSettingsParameter("reportDir");
        if (reportPath == null || reportPath.trim().isEmpty()) {
            reportPath = defaultReportPath;
        }

        String screenshotsDir = context.getSettingsParameter("screenshotsDir");
    	try {
    		//String savingDir = reportPath + FileSystems.getDefault().getSeparator() + screenshotsDir; 
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          //  fileName = "/"+context.getSettingsParameter("devicetype")+ "/"+DataHolder.methodName+"/" + ssTitle  
            //        + DateTimeFormat.forPattern("MMddyyyy_HHmmss").print(new DateTime()) + ".png";
            
            fileName = "/"+screenshotsDir+ "/"+DataHolder.methodName+"/" + ssTitle  
                            + DateTimeFormat.forPattern("MMddyyyy_HHmmss").print(new DateTime()) + ".png";
                    
           // File targetFile = new File(savingDir + fileName);
            File targetFile = new File(reportPath + fileName);
            FileUtils.copyFile(sourceFile, targetFile);
    	} catch(IOException e){}
        //report.log(LogStatus.INFO, "<a href='linkToLogFile'><span class='label info'>file name</span></a>");
    	
        return screenshotsDir + fileName;
    }   
}
