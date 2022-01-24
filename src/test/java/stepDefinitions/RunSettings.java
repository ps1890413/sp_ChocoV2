package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.IOException;
import utilities.Globals;
import utilities.Logs;
import utilities.ServerManager;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber/report.html", "summary",
	"me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports" }, features = {
		"src/test/java/Features" }, glue = { "stepDefinitions" }, monochrome = true, tags = "@automated"

)
public class RunSettings {

    @BeforeClass
    public static void Initialize() throws Exception {
	new Globals().GlobalParamsInitialize();
	new ServerManager().startServer();
    }

    @AfterClass
    public static void teardowDriver() throws IOException, InterruptedException {
	Runtime runtime = Runtime.getRuntime();
	runtime.exec("taskkill /F /IM node.exe");
	runtime.exec("taskkill /F /IM cmd.exe");
	Logs.log().info("Killing appium");

    }

}
