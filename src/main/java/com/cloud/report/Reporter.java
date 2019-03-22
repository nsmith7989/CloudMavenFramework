package com.cloud.report;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import com.cloud.properties.ExecutionContext;
import com.cloud.utils.TestCaseUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter implements IReporter, IInvokedMethodListener, ITestListener {
    private static ExtentReports reporter;
    private static Map<ITestNGMethod, ExtentTest> testReports;
    private static ExecutionContext context;
    private static String testName;

	public Reporter() throws ParserConfigurationException, SAXException, IOException {
        context = ExecutionContext.getInstance();
        reporter = ReportHolder.getReporter();
        testReports = new LinkedHashMap<>();
        reporter.addSystemInfo("Selenium Version",  context.getSettingsParameter("seleniumversion"));
        reporter.addSystemInfo("TestNg Version", context.getSettingsParameter("testngversion"));
        reporter.addSystemInfo("Video Enabled", context.getSettingsParameter("videoenabled"));
        reporter.addSystemInfo("Email Enabled", context.getSettingsParameter("emailenabled"));
      
    }
	
    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
    	reporter.flush();
    	System.out.println("************************Completed Execution for All Test Cases*********************************");
    	TestCaseUtils.SendEmail(context.getSettingsParameter("emailenabled"));
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod() && !testReports.containsKey(iInvokedMethod.getTestMethod())) {  
            startReporting(iInvokedMethod.getTestMethod());
            injectTestReporter(iInvokedMethod.getTestMethod());
        }
    }

    private void startReporting(ITestNGMethod method) {
    		// add method description from code and add test group from runtime testng.xml
    	//ExtentTest testReport =reporter.startTest(method.getMethodName(), method.getDescription()).assignCategory(testName));//method.getGroups()
    	ExtentTest testReport =reporter.startTest(method.getRealClass().getSimpleName(), method.getDescription()).assignCategory(testName);//method.getGroups()
    	//ExtentTest testReport =reporter.startTest(method.getRealClass().getSimpleName(), method.getMethodName());//method.getGroups()
    	testReports.put(method, testReport);
    }

    private void injectTestReporter(ITestNGMethod method) {
        Object testInstance = method.getInstance();
        try {
            Field reportField = testInstance.getClass().getSuperclass().getSuperclass().getDeclaredField("report");
            reportField.setAccessible(true);
            ExtentTest testReport = testReports.get(method);
            if (testReport != null)
            	reportField.set(testInstance, testReport);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Failed to inject the Test Report into the test " + method.getMethodName()
                    + ". Execution terminated!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        if (testReports.get(method) != null) {
            testReports.get(method).log(LogStatus.PASS, "Execution Status : Passed.");
            reOrgReport(method);
        }
        else{
        	 testReports.get(method).log(LogStatus.PASS, "Execution Status : Failed/Skipped.");
        	 reOrgReport(method);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        if (testReports.get(method) != null) {
        	if (result.getThrowable() != null)
        		testReports.get(method).log(LogStatus.FAIL, result.getThrowable());
            testReports.get(method).log(LogStatus.FAIL, "Test Failed");
            reOrgReport(method);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        if (testReports.get(method) != null) {
            testReports.get(method).log(LogStatus.SKIP, "Test Skipped");
            reOrgReport(method);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    	testName = context.getName();
    }

    @Override
    public void onFinish(ITestContext context) {

    	testName = context.getName();
    }
    
    private void reOrgReport(ITestNGMethod method){
        reporter.endTest(testReports.get(method));
        Set<ITestNGMethod> keys = testReports.keySet();
        int i=0;
        for (ITestNGMethod key:keys){
        	if (key.getMethodName().equalsIgnoreCase(method.getMethodName())) 
        		i++;
        }
        if (i>0)
        	testReports.remove(method);
    	
    }
    //@Override
    public String testMethodName(ITestNGMethod method) {
    	return method.getMethodName();
    }
//
}
