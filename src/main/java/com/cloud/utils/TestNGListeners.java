package com.cloud.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class TestNGListeners implements ITestListener {

//	SoftAssert sAssert;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case exection started : " + result.getName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case passed. Details are " + result.getName());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("Verification failed. <br/>Actual is   &#160;&#160;&#160;&#160;&#160;&#160;: "+false + " <br/>Expected is &#160; : " + true);	
		System.out.println("Test Case failed.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {

	}		
	
//	private void verifyTrue(boolean actual){
//    	try{
//    		sAssert = new SoftAssert();
//    		sAssert.assertTrue(actual);
//    	//report.log(LogStatus.PASS, "Verification successful. <br/>Actual is   &#160;&#160;&#160;&#160;&#160;&#160;: "+actual + " <br/>Expected is &#160; : " + true);
//    	}
//    	finally{
//    		report.log(LogStatus.FAIL, "Verification failed. <br/>Actual is   &#160;&#160;&#160;&#160;&#160;&#160;: "+actual + " <br/>Expected is &#160; : " + true);
//		}   	
//    }

}
