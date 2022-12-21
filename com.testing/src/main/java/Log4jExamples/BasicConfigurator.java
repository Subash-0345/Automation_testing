package Log4jExamples;

import org.apache.log4j.Logger;
public class BasicConfigurator {

	static Logger logger = Logger.getLogger(BasicConfigurator.class);// factory design pattern

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		org.apache.log4j.BasicConfigurator.configure();
		logger.debug("This is debug message");
		logger.warn("This is warn message");
		logger.info("This is a Info message");
		logger.error("This is error message");
		logger.fatal("This is a Fatal message");

	}

}
