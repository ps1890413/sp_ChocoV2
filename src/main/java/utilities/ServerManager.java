package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public AppiumDriverLocalService getServer() {
	return server.get();
    }
    public void startServer() {
	try {
	    Logs.log().info("Starting Appium Server");
	    AppiumDriverLocalService server = StartService();
	    server.start();    
	    ServerManager.server.set(server);	    
	    Logs.log().info("Start Appium Server - PASS");
	} catch (Exception e) {
	    e.printStackTrace();
	    Logs.log().fatal("Starting Appium Server - FAIL!" + e.toString());
	    throw e;
	}
    }
    
    public AppiumDriverLocalService StartService() {

	return AppiumDriverLocalService.buildService(
		new AppiumServiceBuilder()
		.usingPort(4723)
		.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
    }
}
