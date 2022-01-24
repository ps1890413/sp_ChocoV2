package stepDefinitions;

import java.io.IOException;

import io.appium.java_client.InteractsWithApps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CaptureResults;
import utilities.DriverManager;
import utilities.Globals;
import utilities.Logs;

public class Hooks {

    @Before
    public void ExecuteBforeScenario(Scenario scenario) throws InterruptedException {
	Globals.ScenarioName = scenario.getName();
	try {
	    new DriverManager().initializeDriver();
	} catch (Exception e) {

	    e.printStackTrace();
	}
	new CaptureResults().startRecording();
    }

    @After
    public void ExecuteAfterScenario(Scenario scenario) throws IOException, InterruptedException {
	Thread.sleep(4000);
	new CaptureResults().stopRecording(Globals.ScenarioName.toString());
	((InteractsWithApps) new DriverManager().getDriver()).closeApp();
	new DriverManager().getDriver().quit();
	Logs.log().info("Driver quit from execution");

    }

}
