package utilities;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.Scenario;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureResults {

    DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
    Date date = new Date();

    public void startRecording() throws InterruptedException {
	try {
	    Logs.log().info("Video recording started for - " + Globals.ScenarioName);
	    ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
	} catch (Exception e) {
	    Logs.log().error("Video recording failed to start for - " + Globals.ScenarioName + e.toString());
	}

    }

    public void stopRecording(String scenarioName) throws IOException {

	String media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
	String dirPath = Globals.platformName + "_" + Globals.deviceName + File.separator + "Videos";
	File videoDir = new File(dirPath);
	FileOutputStream stream = null;
	synchronized (videoDir) {
	    if (!videoDir.exists()) {
		Logs.log().info("Video folder created for device- " + Globals.deviceName);
		videoDir.mkdirs();
	    }
	}
	try {
	    String recordingname = videoDir + File.separator 
		    + scenarioName.toString() + dateFormat.format(date)+ ".mp4";
	    stream = new FileOutputStream(recordingname);
	    stream.write(Base64.decodeBase64(media));
	    stream.close();
	    Logs.log().info("Video recording ended for - " + Globals.ScenarioName);
	} catch (Exception e) {
	    Logs.log().error("error during video capture" + e.toString());
	} finally {
	    if (stream != null) {
		stream.close();
	    }
	}
    }
}
