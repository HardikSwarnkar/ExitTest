package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Pages.searchPage;
import Pages.initializeDriver;
import Test.TestNG;
import Utils.ExelUtils;
import Utils.Util;
import reports.FlipkartExtentReport;


public class baseTest {
	static ExtentReports extent;
	static ExtentTest test;
	static String projectPath=System.getProperty("user.dir");
	
	
	private static Logger logger=LogManager.getLogger(TestNG.class);
	WebDriver driver ;
	static String searchQuery=null;
	static String applicationUrl=null;
	static String browser=null;
	static String productlink=null;
	static String laptops=null;
	static String mobiles=null;
	ExelUtils excelUtils = new ExelUtils("C:\\Users\\hardikswarnkar\\OneDrive - Nagarro\\Desktop\\ExitTest\\exel\\data.xlsx","Sheet1");

	
	

	
	@BeforeTest
    @Parameters("browser")
	public void setUp(@Optional("chrome") String browser) throws FileNotFoundException, IOException{
		initializeDriver driverObject = new initializeDriver();	
		driver = driverObject.initializeDriver(browser);
		
		extent = FlipkartExtentReport.getInstance();
		Properties prop = new Properties();
		prop.load(new FileInputStream(projectPath+"/src/test/resources/config.properties"));
		applicationUrl=prop.getProperty("applicationUrl");
		productlink=prop.getProperty("productlink");
		searchQuery=prop.getProperty("searchQuery");
		laptops=prop.getProperty("laptops");
		mobiles=prop.getProperty("mobiles");
		driver.manage().window().maximize();
		
	}
	
	
	
	
	/*
	 @BeforeMethod
	    public void checkExecutionRequirement(Method method) {
	        excelUtils = new ExelUtils("C:\\Users\\hardikswarnkar\\OneDrive - Nagarro\\Desktop\\ExitTest\\exel\\test_cases.xlsx", "Sheet1");
	        if (!excelUtils.isExecutionRequired(method.getName())) {
	            throw new SkipException("Skipping this test as per the Excel Execution Required field: " + method.getName());
	        }
	    }
*/
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        String screenshotPath = Util.TakingScreenshot(driver, result.getName());
	        // Convert to a relative web path if necessary, or ensure the path is correct
	        String relativePath = new File(System.getProperty("user.dir")).toURI().relativize(new File(screenshotPath).toURI()).getPath();
	        test.log(Status.FAIL, "Test failed: " + result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
	    } else if (ITestResult.SUCCESS == result.getStatus()) {
	        test.log(Status.PASS, "Test passed");
	    } else {
	        test.log(Status.SKIP, "Test skipped");
	    }
	}
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		extent.flush();  
	   
	}

}

