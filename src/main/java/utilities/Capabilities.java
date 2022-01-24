package utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    public DesiredCapabilities getCapblts() throws Exception {

	try {
	    Logs.log().info("Setup Capabilities - START");
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("platformName", Globals.platformName);
	    caps.setCapability("deviceName", Globals.deviceName);
	    caps.setCapability("udid", Globals.udid);

	    if (Globals.platformName.equals("Android")) {

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, Globals.androidAutomationName);
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		caps.setCapability("appPackage", Globals.androidAppPackage);
		caps.setCapability("appActivity", Globals.androidAppActivity);
		caps.setCapability("app", Globals.androidAppUrl);
	    }
	    if (Globals.platformName.equals("iOS")) {

		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, Globals.iOSAutomationName);
		caps.setCapability("bundleId", Globals.iOSBundleId);
		caps.setCapability("app", Globals.iOSAppUrl);

	    }
	    Logs.log().info("App URL is set as - " + caps.getCapability("app"));
	    Logs.log().info("Setup Capabilities - END");
	    return caps;
	} catch (Exception e) {
	    e.printStackTrace();
	    Logs.log().fatal("Setup Capabilities - FAIL!" + e.toString());
	    throw e;
	}
    }
    

}
