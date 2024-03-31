package projectCucumber.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = ".//Features//compose.feature",
	    glue = "projectCucumber.stepdefination",
	    dryRun=false,
	    plugin={"pretty","html:test-output"}
	    )

public class testrunner {

}
