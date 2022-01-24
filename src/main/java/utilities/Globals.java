package utilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Globals {
    public static String platformName = "";
    public static String deviceName = "";
    public static String udid = "";

    public static String androidAutomationName = "";
    public static String androidAppPackage = "";
    public static String androidAppActivity = "";
    public static String androidAppUrl = "";

    public static String iOSAutomationName = "";
    public static String iOSBundleId = "";
    public static String iOSAppUrl = "";

    public static URL serverURL = null;
    public static final long WAIT = 10;
    public static String ScenarioName = "";

    public void GlobalParamsInitialize() throws IOException {
	Properties prprts = null;

	try {
	    prprts = new ReadProperties().getProps("config.properties");
	    
	} catch (Exception e) {

	    e.printStackTrace();
	}
	// device
	platformName = prprts.getProperty("platformName");
	deviceName = prprts.getProperty("deviceName");
	udid = prprts.getProperty("udid");

	// android
	androidAutomationName = prprts.getProperty("androidAutomationName");
	androidAppPackage = prprts.getProperty("androidAppPackage");
	androidAppActivity = prprts.getProperty("androidAppActivity");
	androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
		+ File.separator + "resources" + File.separator + "apps" + File.separator + "app-debug.apk";

	// iOS
	iOSAutomationName = prprts.getProperty("iOSAutomationName");
	iOSBundleId = prprts.getProperty("iOSBundleId");
	iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
		+ "resources" + File.separator + "apps" + File.separator + "APP-NAME.ipa";

    }

}
