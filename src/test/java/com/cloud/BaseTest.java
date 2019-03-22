package com.cloud;

import com.cloud.properties.ExecutionContext;
import com.cloud.report.Reporter;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.Listeners;

@Listeners(Reporter.class)
public abstract class BaseTest {
    protected ExecutionContext context = ExecutionContext.getInstance();
    protected ExtentTest report;
}
