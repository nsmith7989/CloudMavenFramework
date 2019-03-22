package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.pageobjects.HCM.MyDetailsPage;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AssetsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_FndTasksList::icon')]")
	    private WebElement btnTasks;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_fixed_assets_additions:0:_FOTRaT:0:RAtl1']")
	    private WebElement lnkAddAssets;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	    private WebElement selectAssetType;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kf1KBIMG::icon')]")
	    private WebElement btnCategory;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf1SPOP_query:value00::content')]")
	    private WebElement txtMajor;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf1SPOP_query:value10::content')]")
	    private WebElement txtMinor;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf1SEl')]")
	    private WebElement btnCategoryOk;
	
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:descriptionId::content')]")
	    private WebElement txtDescription;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:it1::content')]")
	    private WebElement txtCost;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf3KBIMG::icon')]")
	    private WebElement btnLocation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf3SPOP_query:value00::content')]")
	    private WebElement txtLocation;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:kf3SEl')]")
	    private WebElement btnLocationOk;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:commandButton1')]")
	    private WebElement btnNext;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ITPdc2j_id_4:ITsel::icon')]")
	    private WebElement btnDeprSelectTile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ITPdtl:1:ctb1')]//td[1]/a/span")
	    private WebElement btnCalcDepreciation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ITPdtl:1:d4::ok')]")
	    private WebElement btnConfOk;	
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public AssetsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Assets Page *****************************");
		       this.getScreenDetails();
		    }

	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkAddAssets));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	 // Add Asset link  
		   public boolean isAddAssetLinkDisplayed(){
			   //return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout()); 
			   return lnkAddAssets.isDisplayed();
		   }  
	   
		   public void clickAddAssetLink(){
			   wdwait.until(ExpectedConditions.visibilityOf(lnkAddAssets));
			   lnkAddAssets.click();
			   wdwait.until(ExpectedConditions.visibilityOf(selectAssetType));
			   report.log(LogStatus.PASS, "Clicked on Add Assets Link");
			  
		   } 
		   
		// Asset Type list
		   public boolean isAssetTypeDisplayed(){
			   //return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout()); 
			   return selectAssetType.isDisplayed();
		   } 
		   public void selectAssetType(String strAssetType){
			    this.getScreenDetails();
		    	Select objSelect = new Select(selectAssetType);
		    	objSelect.selectByVisibleText(strAssetType);
		    	SeleniumUtils.delay(2000);
		    	//report.log(LogStatus.PASS, "Selected Asset Type  is: "+strAssetType);
		    }
		   
		// Category button   
		   public boolean isCategoryButtonDisplayed(){
			   return btnCategory.isDisplayed();  	
		   }  
	   
		   public void clickCategoryButton(){
			   btnCategory.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtMajor));
			   report.log(LogStatus.PASS, "Clicked on Category button Button");
			  
		   } 
		   
		   // Major list
		   public void SelectMajor(String strMajor) throws InterruptedException{
			   this.getScreenDetails();
			   txtMajor.click();
			   txtMajor.sendKeys(strMajor);
			  // txtMajor.sendKeys(Keys.ARROW_DOWN);
			   txtMajor.sendKeys(Keys.ENTER);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
		   	//SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected Major  is: "+strMajor);
		   }
		   
		   public boolean isSelectMajorDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtMajor, context.getReactTimeout());
			   } 
		   
		// Minor list
		   public void SelectMinor(String strMinor) throws InterruptedException{
			   txtMinor.click();
			   txtMinor.sendKeys(strMinor);
			  // txtMajor.sendKeys(Keys.ARROW_DOWN);
			   txtMinor.sendKeys(Keys.ENTER);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMinor+"')]")));
			   
		   		//SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected Minor  is: "+strMinor);
		    this.getScreenDetails();
		   }
		   
		   public boolean isSelectMinorDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtMinor, context.getReactTimeout());
			   }  
		   
		   // Click on Major field
		   public void clickMajorText(){
			   txtMajor.click();
		   } 
		// Category Ok button   
		   public boolean isCategoryOkButtonDisplayed(){
			   return btnCategoryOk.isDisplayed();  
			   
		   }  
	   
		   public void clickCategoryOkButton(){
			   btnCategoryOk.click();
			   report.log(LogStatus.PASS, "Clicked on Category Ok button Button");
			  
		   } 
		  
		  // Description field
		   public void enterDescription(String strDescription){
			   SeleniumUtils.delay(2000);
			   txtDescription.clear();
			   txtDescription.click();
			   txtDescription.sendKeys(strDescription);
			   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
		   }
		   
		   public boolean isDescriptionDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtDescription, context.getReactTimeout());
			   }
		   
		   // Cost Field
		   
		   public void enterCost(String strCost){
			   txtCost.clear();
			   txtCost.click();
			   txtCost.sendKeys(strCost);
			  // report.log(LogStatus.PASS, "Entered Description is: "+strCost);
		   }
		   
		   public boolean isCostDisplayed(){
			   return txtCost.isDisplayed();
			   }
		   
		// Location button   
		   public boolean isLocationButtonDisplayed(){
			   return btnLocation.isDisplayed();  	
		   }  
	   
		   public void clickLocationButton(){
			   btnLocation.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtLocation));
			   report.log(LogStatus.PASS, "Clicked on Location button Button"); 
		   } 
		   
		   // Location Field
		   
		   public void enterLocation(String strLocation){
			   this.getScreenDetails();
			   txtLocation.clear();
			   txtLocation.click();
			   txtLocation.sendKeys(strLocation);
			   txtLocation.click();
			   //report.log(LogStatus.PASS, "Entered Location is: "+strLocation);
			   this.getScreenDetails();
		   }
		   
		   public boolean isLocationDisplayed(){
			   return txtLocation.isDisplayed();
			   }
		   
		// Location Ok button   
		   public boolean isLocationOkButtonDisplayed(){
			   return btnLocationOk.isDisplayed();  	
		   }  
	   
		   public void clickLocationOkButton(){
			   this.getScreenDetails();
			   btnLocationOk.click();
			   report.log(LogStatus.PASS, "Clicked on Location Ok  button Button");
			   
			  
		   } 
		 // Next Button
		   public boolean isNextButtonDisplayed(){
			   return btnNext.isDisplayed();  	
		   }  
		   
		   public AddAssetPage clickNextButton() throws TestException{
			   SeleniumUtils.delay(3000);
				//wdwait.until(ExpectedConditions.visibilityOf(btnNext));
				btnNext.click();
				report.log(LogStatus.PASS, "Clicked on Next Button");
				return new AddAssetPage(driver,report);
			 }
		   
		// Depreciation Select Tile button   
		   public boolean isDeprSelectTileButtonDisplayed(){
			   return btnDeprSelectTile.isDisplayed();  	
		   }  
	   
		   public void clickDeprSelectTileButton(){
			   btnDeprSelectTile.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnCalcDepreciation));
			   report.log(LogStatus.PASS, "Clicked on Depreciation Select Tile Button");
			   this.getScreenDetails();
		   } 
		   
		// Calculate Depreciation Button   
		   public boolean isCalculateDepreciationButtonDisplayed(){
			   return btnCalcDepreciation.isDisplayed();  	
		   }  
	   
		   public void clickCalculateDepreciationButton(){
			   btnCalcDepreciation.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Calculate Depreciation Button");
			   this.getScreenDetails();
		   } 
		   
		// Confirmation Ok Button   
		   public boolean isConfOkButtonDisplayed(){
			   return btnConfOk.isDisplayed();  	
		   }  
	   
		   public void clickConfOkButton(){
			   btnConfOk.click();
			   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");

		   } 
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Assets page is Loaded Successfully");
	    	 if(btnTasks.isDisplayed())
	    	 {
	    		 return true;
	    		 
	    	 } else {
	    		 return false;
	    	 }     	
		}
		
		public Item getScreenDetails(String strTitle){
	        String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
	        report.addScreenCapture(xyz);
	        String projectPath = System.getProperty("user.dir");          
	        String fullprojectPath = projectPath+"/report/"+xyz;
	        report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
	        return new Item(xyz);
	    }
	    
	    
		public Item getScreenDetails(){
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Assets Page</span></a>");
		   	return new Item(xyz);
	   }
}
