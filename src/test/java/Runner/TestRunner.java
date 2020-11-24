package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features/SkyNewsHomepage.feature"},
				 glue ="StepDefinitions",
				 dryRun = false,
				 monochrome =true,
				 tags="@Regression",
				 plugin= {"pretty","json:target/cucumber.json","html:target/results.html"}
				)
public class TestRunner {

}
