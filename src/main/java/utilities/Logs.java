package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
  
    public static Logger log() {
	return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
}
}