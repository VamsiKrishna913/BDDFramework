package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue="steps",
		features="src\\test\\resources\\features\\regression\\ValidateLogin.feature",
		dryRun=false,
		tags="@Smoke",
		stepNotifications=true
		)


public class SmokeRunner {

}
