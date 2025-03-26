package com.Magento.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\com.Magento.Features\\3_ProductSelection.feature", glue = {
		"com.Magento.StepDefinition",
		"com.Magento.Hooks" }, plugin = { "pretty", "html:target/com.Magento.CucumberReport/report.html" })


public class productSelectionTestRunner extends AbstractTestNGCucumberTests{

}
