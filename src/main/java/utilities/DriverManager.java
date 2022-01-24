package utilities;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DriverManager {
    private static ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();

    
    public AppiumDriver<MobileElement> getDriver() {
	return driver.get();
    }
    public void setDriver(AppiumDriver<MobileElement> setdriver) {
	driver.set(setdriver);
    }

    public void initializeDriver() throws Exception {
	AppiumDriver<MobileElement> driver = null;

	try {
	    Logs.log().info("Setup Driver - START");
	    if (Globals.platformName.equals("Android")) {

		driver = new AndroidDriver<MobileElement>(new ServerManager().getServer().getUrl(),
			new Capabilities().getCapblts());
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	    }
	    if (Globals.platformName.equals("iOS")) {
		driver = new IOSDriver<MobileElement>(new ServerManager().getServer().getUrl(),
			new Capabilities().getCapblts());
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	    }
	    Logs.log().info("Setup Driver - END");
	    this.driver.set(driver);

	} catch (Exception e) {
	    e.printStackTrace();
	    Logs.log().fatal("Setup Driver - FAIL" + e.toString());
	    throw e;
	}
    }
}
