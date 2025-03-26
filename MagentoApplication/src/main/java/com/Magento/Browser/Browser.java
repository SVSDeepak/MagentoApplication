package com.Magento.Browser;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Browser {

	/*
	 * Necessary objects declared globally
	 */
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions act;
	public static Select select;

	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;

	public static void init(String reportname) {
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//target//com.Magento.Extentreports//" + reportname + ".html");
		extent.attachReporter(reporter);
	}
	/*
	 * Open the browser based on the choice
	 */

	public static void openbrowser(String browser) {
		
	
		logger1.log(Status.INFO, "Opening the browser");
		try {
			if (browser.equalsIgnoreCase("chrome"))
				driver = new ChromeDriver();
			else if (browser.equalsIgnoreCase("firefox"))
				driver = new FirefoxDriver();
			else if (browser.equalsIgnoreCase("edge"))
				driver = new EdgeDriver();
			else
				throw new Exception("Invalid browser");
			logger1.log(Status.PASS, "The browser has been opened successfully");

		} catch (Exception e) {
			logger1.log(Status.FAIL, "The browser has not been opened :"+e);
			System.out.println("Exception in openbrowser method : " + e);
			System.exit(0);
		}

	}

	/*
	 * Navigating to the given Url on the choice
	 */

	public static void navigateTourl(String url) {
	
		
		logger1.log(Status.INFO, "Navigate to resepective url page");
		try {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			js = (JavascriptExecutor) driver;
			act = new Actions(driver);
			logger1.log(Status.PASS, "Successfully navigated to provided url page");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error occured in navigating to url :"+e);
			System.out.println("Exception in navigateToUrl method : " + e);
			System.exit(0);
		}
	

	}

	/*
	 * Closing the browser
	 */

	public static void closeBrowser() {
		
	
		logger1.log(Status.INFO, "Closing the browser");
		try {
			driver.quit();
			logger1.log(Status.PASS, "Browser has been closed successfully");
		} catch (Exception e) {
			logger1.log(Status.FAIL, "Error occured in closing the browser : "+e);
			System.out.println("Exception in closeBrowser method : " + e);
		}
	

	}

}
