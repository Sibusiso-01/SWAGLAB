package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {


        private static ExtentReports extent;
        private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

        // Method to create and return the ExtentReports instance
        public static ExtentReports getExtentReports() {
            if (extent == null) {
                String reportPath = STR."\{System.getProperty("user.dir")}/test-output/ExtentReport.html";
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
                sparkReporter.config().setReportName("Automation Test Report");
                sparkReporter.config().setDocumentTitle("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
                extent.setSystemInfo("Tester", "Sibusiso");
                extent.setSystemInfo("Environment", "QA");
                extent.setSystemInfo("OS", System.getProperty("os.name"));
            }
            return extent;
        }

        // Set the ExtentTest object for the current test thread
        public static void setExtentTest(ExtentTest test) {
            extentTest.set(test);
        }

        // Get the ExtentTest object for the current test thread
        public static ExtentTest getExtentTest() {
            return extentTest.get();
        }



}
