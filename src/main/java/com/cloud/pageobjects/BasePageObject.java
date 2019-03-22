package com.cloud.pageobjects;

import com.cloud.properties.ExecutionContext;
import com.relevantcodes.extentreports.ExtentTest;

public abstract class BasePageObject {
    protected ExecutionContext context;
    protected ExtentTest report;

    protected BasePageObject(ExtentTest report) {
        this.context = ExecutionContext.getInstance();
        this.report = report;
    }
    public abstract boolean isDisplayed();
}
