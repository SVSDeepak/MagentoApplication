package com.Magento.Hooks;

import com.Magento.Browser.Browser;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class hooks extends Browser{
	
	@BeforeAll
	public static void initilizingExtentReport()
	{
		Browser.init("ExtentReport");
	}

	@Before
	public static void creatingExtentTest(Scenario scenario)
	{
		logger1 = extent.createTest(scenario.getName());
	}
	
	
	@After
	public static void closeapplication() {
		Browser.closeBrowser();
		extent.flush();	
	}

}
