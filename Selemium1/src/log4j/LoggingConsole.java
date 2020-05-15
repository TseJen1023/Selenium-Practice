package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingConsole {
	private static final Logger log = LogManager.getLogger(LoggingDemo.class.getName()) ;
	public static void main(String[] args) {
		log.debug("Debug message logged");
		log.error("Error message logged");
		log.fatal("Fatal message logged");
	}
}