package com.cloud.pageobjects.HCM;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Contains object properties and methods for Directory Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class DirectoryPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//span[contains(.,'Directory')]")
	private WebElement txtDirectory;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'FOTsr1:0:it1::content')]")
	private WebElement txtLookingFor;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'INFO:0:MAnt2:1:SP1:r4:1:socBloodType::content')]")
	private WebElement selectBloodType;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:cil1::icon']")
	private WebElement searchIcon;
	 
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:r1:0:pt1:r4:0:ls1:AT1::db']")
	private WebElement directoryTable;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Done')]")
	private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//span[contains(@class,'AppsBoldFont nowrap')]")
	private WebElement textNameDesignation;
	
	private List<WebElement> rowcount;
	private List<WebElement> colcount;
	
	
	 public DirectoryPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtDirectory));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Directory Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isDirectoryPageDisplayed(){
		 report.log(LogStatus.PASS, "Directory page is Displayed");
		 return txtDirectory.isDisplayed();
		}
	 
	 public String getNameAndDesignation() {
		 return textNameDesignation.getText();
	 }
	 
	 public boolean verifyName(String strPersonName) {
		  if (textNameDesignation.getText().contains(strPersonName))
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
			 
	 }
	 
	@SuppressWarnings("unchecked")
	public void selectWebtableElement(String strPersonName,String strDeptName)
	{	
		rowcount=(List<WebElement>) directoryTable.findElements(By.tagName("tr"));
		int rownum=rowcount.size();
		for (int row=1;row<=rownum;row++)
		{
			WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:r1:0:pt1:r4:0:ls1:AT1::db']/table/tbody/tr["+row+"]/td[3]"));
			String actualText=cellNametext.getText();
			System.out.println("actual text is "+actualText);
			
			WebElement cellDepartmenttext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:r1:0:pt1:r4:0:ls1:AT1::db']/table/tbody/tr["+row+"]/td[4]"));
			String actualDeptText=cellDepartmenttext.getText();
			System.out.println("actual text is "+actualDeptText);
			
			if(actualText.contains(strPersonName)  && actualDeptText.contains(strDeptName))
			{
				System.out.println("found proper person name and department name");
				report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName+" and department name is "+strDeptName);
				driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:r1:0:pt1:r4:0:ls1:AT1::db']/table/tbody/tr["+row+"]/td[2]")).click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails();
				break;
			}
		}
	}		
	
	 public void setLookingFor(String SearchText)
	 {
		 txtLookingFor.clear();
		 txtLookingFor.sendKeys(SearchText);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered address is: "+SearchText);
		
	 }
	 
	 public void clickSearchIcon()
	 {
		 searchIcon.click();
		 SeleniumUtils.delay(5000);
	 }
	
	 public void clickDoneButton()
	 {
		 btnDone.click();
		 SeleniumUtils.delay(5000);
	 }
	
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Edit My Details Personal Information Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtDirectory, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryDirectoryInformation", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>DirectoryInformation Page</span></a>");
	    	return new Item(xyz);
	    }
	  
	  public Item getScreenDetails(String strTitle){
		   	String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
		   	return new Item(xyz);
	   }
}
