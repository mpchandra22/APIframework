package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/ChangeRequest.feature",
				 glue = {"steps","hooks"},
				 monochrome = true, 
				 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class RunTest extends AbstractTestNGCucumberTests{

}

