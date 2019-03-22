package com.cloud.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.FileImportAndExportPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.pageobjects.HCM.DirectoryPage;
import com.cloud.pageobjects.HCM.GoalsPage;
import com.cloud.pageobjects.HCM.MyDetailsPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.NewWorkersProcessPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.pageobjects.HCM.ScheduleAbsencePage;
import com.cloud.pageobjects.HCM.SearchProfilesPage;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Contains object properties and methods for Home Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class HomePage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'UIShome::icon')]")	
	private WebElement imgHome;
	
	//@FindBy(how=How.XPATH, using = "//*[@id='pt1:_UISmmLink::icon']")
	//@FindBy(how=How.ID, using = "pt1:_UISmmLink::icon")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':_UISmmLink::icon')]")
	private WebElement iconNavigator;
		
	@FindBy(how=How.XPATH,using=".//*[@id='pt1:nv_PER_HCMPEOPLETOP_FUSE_PER_INFO']")
	private WebElement lnkPersonalInformation;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_career_profiles']")
	private WebElement lnkProfiles;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_workforce_management_new_person']")
	private WebElement lnkNewPerson;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_workforce_management_person_management']")
	private WebElement lnkPersonManagement;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_PER_HCMPEOPLETOP_FUSE_DIRECTORY']")
	private WebElement lnkDirectory;
	
	@FindBy(how=How.ID, using = "pt1:_UIScmil1u::icon")
	private WebElement userIcon;
	
	@FindBy(how=How.XPATH, using = "//span[@class='text-normal-1 feeds-title']")
	private WebElement userName;
	
	@FindBy(how=How.XPATH, using = "//*[@id='pt1:_UISlg1']")
	private WebElement lnkSignOut;
	
	@FindBy(how=How.XPATH, using = "//*[@id='pt1:nv_HWM_HCMWFMWORKAREA_FUSE_TIME']")
	private WebElement lnkTime;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_PER_HCMPEOPLETOP_FUSE_MY_TEAM']")
	private WebElement lnkMyTeam;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:_UISatr:0:cil1::icon']")
	private WebElement iconNotifications;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:_UISatr:0:lView1']")
	private WebElement listNotifications;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_general_accounting_journals']")
	private WebElement lnkJournals;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_payables_payables_invoices']")
	private WebElement lnkinvoices;
	
	//@FindBy(how=How.XPATH,using="//*[@id='_FOpt1:nv_itemNode_payables_payables_payments']")
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_payables_payables_payments']")
	private WebElement lnkPayments;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_career_goals']|//*[@id='pt1:nv_itemNode_my_information_goals']")
	private WebElement lnkGoals;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_receivables_billing']")
	private WebElement lnkBilling;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_receivables_receivables_balances']")
	private WebElement lnkAccountsReceivable;
	
	@FindBy(how=How.XPATH,using="//*[@id='pt1:nv_moreLk']")
    private WebElement lnkMore;
    
    @FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_tools_scheduled_processes']")
    private WebElement lnkScheduledProcesses;
    
    @FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_cash_management_bank_statements_and_reconciliation']")
	private WebElement lnkBankStatementsReconc;
    
    @FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_tools_file_import_and_export']")
	private WebElement lnkfileImportExport;
    
    @FindBy(how=How.XPATH,using="//*[@id='pt1:nv_itemNode_fixed_assets_additions']")
	private WebElement lnkAssets;
	
	private List<WebElement> rowcount;
	
	 public HomePage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(imgHome));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Home Page *****************************");
	     this.getScreenDetails();
	 }
	
	@SuppressWarnings("unchecked")
	public void selectNotification(String strNotificationName)
		{	
			System.out.println("Pending Notifications is :"+listNotifications.getText());
			rowcount=(List<WebElement>) listNotifications.findElements(By.tagName("tr"));
		 	
			int rownum=rowcount.size();
			int found=0;
			for (int row=0;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath(".//*[@id='pt1:_UISatr:0:lView1:"+row+":gl2']"));
				String actualText=cellNametext.getText();
				report.log(LogStatus.INFO, "Selected notification is "+actualText);
				
				if(actualText.contains(strNotificationName))
				{
					cellNametext.click();
					SeleniumUtils.delay(10000);
					this.getScreenDetails("Select Notification");
					found=1;
					break;
				}
			}
			if (found>0)
			{
				report.log(LogStatus.INFO, "Clicked on proper pending notification");
			}
			else
			{
				report.log(LogStatus.FAIL, "Requested notification is not exists in the Notification List");
			}
		}		

	 public boolean isHomeImageDisplayed()
	 {
	    	return imgHome.isDisplayed();
	 }
	
	 public String getUserName(){
		return userName.getText();
		 
	 }
	 
	 public void clickUserIcon()
	 {
			userIcon.click();
			SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Clicked on user Icon to signout");
	 }
	 
	 
	 public void clickNotificationsrIcon()
	 {
		 	iconNotifications.click();
			SeleniumUtils.delay(5000);
		    report.log(LogStatus.PASS, "Clicked on Notifications Icon");
	 }	
	 
	 
	 public void clickSignOut(){
		 lnkSignOut.click();
		 SeleniumUtils.delay(5000);
		    report.log(LogStatus.PASS, "Clicked on signout link");
		 }
	
	 public void clickImgHome(){
		 imgHome.click();
		 SeleniumUtils.delay(5000);
//		 Alert alert = driver.switchTo().alert();
//	     alert.sendKeys("Yes");
//	     alert.accept();
		 report.log(LogStatus.PASS, "Clicked on Home Image link");
		 }

	 public void clickNavigatorIcon(){
		iconNavigator.click();
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].click();", iconNavigator);*/
        // new Actions(driver).moveToElement(iconNavigator).click().perform();
        SeleniumUtils.delay(2000);
        this.getScreenDetails("Navigator Icon Click");
	    report.log(LogStatus.PASS, "Clicked on Navigator Icon");
	 }
	 
	 public AccountsReceivablePage clickAccountsReceivable() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf( lnkAccountsReceivable));
			 lnkAccountsReceivable.click();
			report.log(LogStatus.PASS, "Clicked on Accounts Receivable link");
			return new AccountsReceivablePage(driver,report);
		 }
	

	 public MyDetailsPage clickPersonalInformation() throws TestException{
		wdwait.until(ExpectedConditions.visibilityOf(lnkPersonalInformation));
		lnkPersonalInformation.click();
		report.log(LogStatus.PASS, "Clicked on PersonalInformation link");
		return new MyDetailsPage(driver,report);
	 }
	 
	  
	 public SearchProfilesPage clickProfilesLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkProfiles));
			lnkProfiles.click();
			report.log(LogStatus.PASS, "Clicked on Profiles link");
			return new SearchProfilesPage(driver,report);
		 }
	
	 
	 public NewWorkersProcessPage clickNewPersonLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkNewPerson));
			lnkNewPerson.click();
			report.log(LogStatus.PASS, "Clicked on New Person link");
			return new NewWorkersProcessPage(driver,report);
		 }
	 
	 public ScheduleAbsencePage clickTimeLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkTime));
			lnkTime.click();
			report.log(LogStatus.PASS, "Clicked on Time link");
			return new ScheduleAbsencePage(driver,report);
		 }
	 
	 public PersonManagementPage clickPersonManagement() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkPersonManagement));
		 	lnkPersonManagement.click();
		 	report.log(LogStatus.PASS, "Clicked on Person Management link");
			return new PersonManagementPage(driver,report);
		 }
	 
	 
	 
	 public MyTeamPage clickMyTeamLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkMyTeam));
			lnkMyTeam.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on MyTeam link");
			return new MyTeamPage(driver,report);
		 }
	 
	 public DirectoryPage clickDirectory() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkDirectory));
			lnkDirectory.click();
			//SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Directory link");
			return new DirectoryPage(driver,report);
		 }
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Home Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, imgHome, context.getFindTimeout());
    }
	 
	 public JournalsPage clickJournals() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkJournals));
			lnkJournals.click();
			report.log(LogStatus.PASS, "Clicked on Journals link");
			return new JournalsPage(driver,report);
		 }
	 
	 public InvoicesPage clickInvoices() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkinvoices));
			lnkinvoices.click();
			report.log(LogStatus.PASS, "Clicked on Invoices link");
			return new InvoicesPage(driver,report);
		 }
	 
	 
	 public GoalsPage clickGoals() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkGoals));
			lnkGoals.click();
			report.log(LogStatus.PASS, "Clicked on Goals link");
			return new GoalsPage(driver,report);
		 }
	 
	 public OverviewPage clickPayments() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkPayments));
			lnkPayments.click();
			report.log(LogStatus.PASS, "Clicked on Payments link");
			return new OverviewPage(driver,report);
		 }
	 
	 public BillingPage clickBilling() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkBilling));
			lnkBilling.click();
			report.log(LogStatus.PASS, "Clicked on Billing link");
			return new BillingPage(driver,report);
		 }
	 
	 public ScheduledProcessesPage clickScheduledProcesses() throws TestException{
		 if(lnkScheduledProcesses.isDisplayed()) {
			 lnkScheduledProcesses.click();
			 
		 }else {
			 wdwait.until(ExpectedConditions.visibilityOf(lnkMore));
			 lnkMore.click();
			 wdwait.until(ExpectedConditions.visibilityOf(lnkScheduledProcesses));
			 lnkScheduledProcesses.click();
		 }
		 	report.log(LogStatus.PASS, "Clicked on Scheduled Processes link");
			return new ScheduledProcessesPage(driver,report);
		 }
	 
	 public Overview_BankStatementPage clickBankStatementsReconciliation() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkBankStatementsReconc));
			lnkBankStatementsReconc.click();
			report.log(LogStatus.PASS, "Clicked on Bank Statements and Reconciliation link");
			return new Overview_BankStatementPage(driver,report);
		 }
	 
	 public FileImportAndExportPage clickFileImportExport() throws TestException{
		 if(lnkfileImportExport.isDisplayed()) {
			 lnkfileImportExport.click();
			 
		 }else {
			 wdwait.until(ExpectedConditions.visibilityOf(lnkMore));
			 lnkMore.click();
			 wdwait.until(ExpectedConditions.visibilityOf(lnkfileImportExport));
			 lnkfileImportExport.click();
		 }
		 	report.log(LogStatus.PASS, "Clicked on File Import and Export link");
			return new FileImportAndExportPage(driver,report);
		 }

	 public AssetsPage clickAssets() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkAssets));
			lnkAssets.click();
			report.log(LogStatus.PASS, "Clicked on Assets link");
			return new AssetsPage(driver,report);
		 }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryHome", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Home Page</span></a>");
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
