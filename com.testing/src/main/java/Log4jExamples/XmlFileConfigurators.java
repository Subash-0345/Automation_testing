package Log4jExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class XmlFileConfigurators {

	static Logger logger = Logger.getLogger(XmlFileConfigurators.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("Log4j.xml");
		logger.debug("This is debug message");
		logger.warn("This is warn message");
		logger.info("This is a Info message");
		logger.error("This is error message");
		logger.fatal("This is a Fatal message");
	}

}
