package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties prprts = new Properties();

    public Properties getProps(String propertiesfile) throws Exception {
	try {
	    Logs.log().info("Load Properties - START");
	    if (prprts.isEmpty()) {
		Properties prprts = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesfile);
		prprts.load(inputStream);
		Logs.log().info("Load Properties - END");
		return prprts;
		
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    Logs.log().fatal("Load Properties - FAIL" + e.toString());
	    throw e;
	}
	return prprts;
    }

}
