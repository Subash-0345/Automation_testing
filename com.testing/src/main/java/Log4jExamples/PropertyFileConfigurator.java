package Log4jExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyFileConfigurator {
	static Logger logger = Logger.getLogger(PropertyFileConfigurator.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PropertyConfigurator.configure("log4j.properties");

		logger.debug("This is debug message");
		logger.warn("This is warn message");
		logger.info("This is a Info message");
		logger.error("This is error message");
		logger.fatal("This is a Fatal message");
	}

}
