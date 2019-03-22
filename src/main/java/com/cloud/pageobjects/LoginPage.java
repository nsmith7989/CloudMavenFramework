package com.cloud.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cloud.exceptions.TestException;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.cloud.models.Item;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * Contains object properties and methods for Login Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */

public class LoginPage extends BasePageObject {
 
	public WebDriver driver;
	
	 @FindBy(how=How.ID, using = "userid")
	 private WebElement txtUsername;
    
    @FindBy(how=How.ID, using = "password")
    private WebElement txtPassword;
    
    @FindBy(how=How.ID, using = "btnActive")
    private WebElement btnSignIn;
    
    @FindBy(how=How.LINK_TEXT, using = "forgotLink")
    private WebElement lnkForgotPassword;
    
    @FindBy(how=How.ID, using = "Languages")
    private WebElement selectLanguage;
    
    public WebDriverWait wdwait;
    
    
	/**
	* Initializing page objects for Login Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	 * @throws InterruptedException 
	*/
    
    public LoginPage(WebDriver driver, ExtentTest report) throws TestException 
    {
	     super(report);
		 this.driver=driver;
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtUsername));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Login Page *****************************");
	     //this.getScreenDetails();
	     this.getScreenDetails("Login Page");
	 }
    
    public void enterUsername(String userName){
    	txtUsername.clear();
    	txtUsername.click();
    	txtUsername.sendKeys(userName);
    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
    }
    
    public void enterPassword(String passWord){
    	txtPassword.clear();
    	txtPassword.click();
    	txtPassword.sendKeys(passWord);
    	report.log(LogStatus.PASS, "Entered Password is: "+passWord);
    }
    
    public void clickSignInButton(){
    	btnSignIn.click();
        report.log(LogStatus.PASS, "Clicked on Sign in Button");
    }
    
    public HomePage loginToCloudApplication(String username, String password) throws TestException, InterruptedException
    {
	    if (!(username == null || username.isEmpty())) {
	    	enterUsername(username);
	    }
	    if (!(password == null || password.isEmpty())) {
	      	enterPassword(password);
	    }
	    if (btnSignIn.isEnabled())
	    {
	       	clickSignInButton();
	       	report.addScreenCapture(Screenshot.takeScreenshotX(driver, "HomePage", context));
	    } 
	        return new HomePage(driver,report);
    }  
    
    public boolean isDisplayed() {
   	 report.log(LogStatus.PASS, "Login page is Loaded Successfully");
   	 return SeleniumUtils.isDisplayed(driver, txtUsername, context.getFindTimeout())
        		|| SeleniumUtils.isDisplayed(driver, txtPassword, context.getFindTimeout()); 
   	
   }
    
    
    public String getUsername(){
    	return txtUsername.getText();
    }
    
    public String getPassword(){
    	return txtPassword.getText();
    }
    
    
    public void clickForgotPassword(){
    	lnkForgotPassword.click();
    }
    
    public boolean isUserNameDisplayed(){
    	return SeleniumUtils.isDisplayed(driver, txtUsername, context.getReactTimeout());
    }
    
    public boolean isPassWordDisplayed(){
    	return SeleniumUtils.isDisplayed(driver, txtPassword, context.getReactTimeout());
    }
    
    public boolean isForgotPasswordDisplayed(){
    	return SeleniumUtils.isDisplayed(driver, lnkForgotPassword, context.getReactTimeout());
    }
    
    public boolean isSignInButtonDisplayed(){
    	return SeleniumUtils.isDisplayed(driver, btnSignIn, context.getReactTimeout());
    }
    
    public void selectLanguage(String strLanguage){
    	report.log(LogStatus.PASS, "Select any langauge from SelectLangauge dropdown");
    	Select objSelect = new Select(selectLanguage);
    	objSelect.selectByVisibleText(strLanguage);
    }
    
    public Item getScreenDetails(){
	   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
	   	report.addScreenCapture(xyz);
	   	String projectPath = System.getProperty("user.dir");    	
	   	String fullprojectPath = projectPath+"/report/"+xyz;
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Login Page</span></a>");
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
