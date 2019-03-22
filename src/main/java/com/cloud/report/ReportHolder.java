package com.cloud.report;

import com.cloud.properties.ExecutionContext;
import com.cloud.utils.TestCaseUtils;
import com.relevantcodes.extentreports.ExtentReports;


public class ReportHolder {
    private static ExtentReports reporter;
    private final static ExecutionContext context = ExecutionContext.getInstance();
    private final static ReportHolder instance = new ReportHolder();
    private final static String defaultReportPath = "report";
    private final static String defaultReportName = "TestExecutionReport";

    private ReportHolder() {
        reporter = new ExtentReports(getReportPath(), overrideReport());
        //reporter.loadConfig(new File("extent-config.xml"));
    }

    public static String getReportPath() {
        String reportPath = context.getSettingsParameter("reportDir");
       // String device = ""
        if (reportPath == null || reportPath.trim().isEmpty()) {
            reportPath = defaultReportPath;
        }
       // return reportPath + "/"+context.getSettingsParameter("devicetype")+"/" + defaultReportName+"_" +TestCaseUtils.randomNumber() +".html";
       
        System.out.println(reportPath + "/"+ defaultReportName+"_" +TestCaseUtils.randomNumber() +".html");
        return reportPath + "/"+ defaultReportName+"_" +TestCaseUtils.randomNumber() +".html";
    }

    private static boolean overrideReport() {
        return Boolean.parseBoolean(context.getSettingsParameter("replaceExistingReport"));
    }

    public static ExtentReports getReporter() {
        return reporter;
    }
}
