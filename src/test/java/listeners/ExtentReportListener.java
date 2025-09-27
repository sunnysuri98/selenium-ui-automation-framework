package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ScreenShotUtils;

public class ExtentReportListener implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;

    ExtentTest test;

    public void configureReport() {

        String reportDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportDir).mkdirs();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "TestingReport-" + timeStamp + ".html";

        String reportPath = reportDir + File.separator + reportName;

        htmlReporter = new ExtentSparkReporter(reportPath);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional-Testing Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onStart(ITestContext context) {
        configureReport();
    }

    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + result.getName());
        test.log(Status.PASS,
                MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getName());
        test.log(Status.FAIL,
                MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
        test.fail(result.getThrowable());

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String screenshotPath = ScreenShotUtils.captureScreenShot(driver, result.getName());

        try {
            test.addScreenCaptureFromBase64String(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getName());
        test.log(Status.SKIP,
                MarkupHelper.createLabel("Name of the skip test case is: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
