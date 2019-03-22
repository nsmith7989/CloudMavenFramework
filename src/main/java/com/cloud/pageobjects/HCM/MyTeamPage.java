package com.cloud.pageobjects.HCM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Contains object properties and methods for Person Management Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class MyTeamPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'My Team ')]")
	private WebElement txtMyTeam;
	
	//input[@name='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value00']
	@FindBy(how=How.NAME, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value00")
	private WebElement txtName;
	
	@FindBy(how=How.NAME, using = "//input[contains(@id,'management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value10::content')]")
	private WebElement txtPersonNumber;
	
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table2')]")
	private WebElement tablePersonNames;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:psl3::c']")
	private WebElement tableTeam;
	
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt2:2:r1:0:r1:0:pt1:ap1:Termi1:0:Action::content')]")
	private WebElement selectAction;
	
	
	private List<WebElement> rowcount;
	
		 public MyTeamPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 20);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtMyTeam));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* My Team Page *****************************");
		     this.getScreenDetails();
		 }
	 
	 
		public void selectPersonName(String strPersonName)
			{	
				rowcount=(List<WebElement>) tablePersonNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				for (int row=0;row<rownum;row++)
				{
					WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2:"+row+":gl1']"));
					String actualText=cellNametext.getText();
					System.out.println("actual text is "+actualText);
					
					if(actualText.contains(strPersonName))
					{
						System.out.println("found proper person name and department name");
						report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
						cellNametext.click();
						SeleniumUtils.delay(8000);
						this.getScreenDetails();
						break;
					}
				}
			}	
		
		
		public void selectTeamMemberwithAction(String strPersonName,String strActionType,String strSubActionType) throws TestException{
			
			rowcount=(List<WebElement>) tableTeam.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=0;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:i1:"+row+":cl1']"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.contains(strPersonName))
				{
					System.out.println("found proper person name and department name");
					report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
					driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:i1:"+row+":commandButton1']")).click();
					SeleniumUtils.delay(3000);
					if(strActionType.equalsIgnoreCase("Absences"))
					{
						driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:0:dcm1']/td[2]")).click();
						SeleniumUtils.delay(3000);
						
						if(strSubActionType.equalsIgnoreCase("Manage Absence Records"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:0:dci1:0:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
							
						}
						else
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:0:dci1:1:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
							
						}
					}
					else if(strActionType.equalsIgnoreCase("Personal and Employment"))
					{
						driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dcm1']/td[2]")).click();
						SeleniumUtils.delay(3000);
						
						if(strSubActionType.equalsIgnoreCase("Change Location"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:0:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
						}
						else if(strSubActionType.equalsIgnoreCase("Change Manager"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:1:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
							
						}
						else if(strSubActionType.equalsIgnoreCase("Change Working Hours"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:2:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
						}
						else if(strSubActionType.equalsIgnoreCase("Manage Direct Reports"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:6:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
						}
						else if(strSubActionType.equalsIgnoreCase("Manage Document Records"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:7:dccmi1']/td[2]")).click();
							//WebElement ele=driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:7:dccmi1']/td[2]"));
							//new Actions(driver).moveToElement(ele).click().perform();
							SeleniumUtils.delay(5000);
						}
						else if(strSubActionType.equalsIgnoreCase("Promote"))
						{
							SeleniumUtils.scroll(driver, 0, 300);
							//below line is for Cole Ross user
							//driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:10:dccmi1']/td[2]")).click();
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:13:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
							
						}
						else if(strSubActionType.equalsIgnoreCase("Terminate"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:11:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
							
						}
						else if(strSubActionType.equalsIgnoreCase("Transfer"))
						{
							driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:2:dci1:12:dccmi1']/td[2]")).click();
							SeleniumUtils.delay(5000);
						}
						else
						{
							report.log(LogStatus.FAIL, "Step Fail. Entered invalid choice...Please provide valid input");
						}
					}
					this.getScreenDetails("Actions Screen");
					break;
				}
			}
		}	
	
		
		public void selectTeamMember(String strPersonName)
		{	
			rowcount=(List<WebElement>) tableTeam.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=0;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:i1:"+row+":cl1']"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.contains(strPersonName))
				{
					System.out.println("found proper person name and department name");
					report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
					driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:i1:"+row+":commandButton1']")).click();
					SeleniumUtils.delay(3000);
					driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:0:dcm1']/td[2]")).click();
					SeleniumUtils.delay(3000);
					driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:_FOTsr1:0:pt1z:am1:dc_i1:0:dci1:0:dccmi1']/td[2]")).click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("ManageAbsenceRecords");
					break;
				}
			}
		}	
	
		
		public void clickConfirmatioDialog(String strYesOrNO)
		{
			this.getScreenDetails();
			if(strYesOrNO.equalsIgnoreCase("Yes"))
			{
				driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//button[contains(.,'No')]")).click();	
			}
			
			SeleniumUtils.delay(8000);
				
		}

		 public boolean isMyDetailsPageDisplayed()
		 {
			 return txtMyTeam.isDisplayed();
		 }
		 
		
		 public void selectAction(String strAction)
		 {
		    	report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(2000);
		 }
	 
		public void enterName(String strName)
		{
			txtName.sendKeys(strName);
			SeleniumUtils.delay(2000);
		}
		
	 
		public void enterPersonNumber(String strPersonNumber)
		{
			txtPersonNumber.sendKeys(strPersonNumber);
			SeleniumUtils.delay(2000);
		}
	
		 public void clickSearchButton() throws TestException
		 {
			btnSearch.click();
			SeleniumUtils.delay(5000);
			SeleniumUtils.scroll(driver, 0, -4000);
			this.getScreenDetails();
		    report.log(LogStatus.PASS, "Clicked on Search button");
		 }
		 
		
		 public boolean isDisplayed()
		 {
	    	 report.log(LogStatus.PASS, "My Details Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtMyTeam, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "My Team", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>My Team Page</span></a>");
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
