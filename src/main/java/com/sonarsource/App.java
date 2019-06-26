package com.sonarsource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	protected static Logger logger = LogManager.getLogger(App.class);

	public static void main( String[] args )
	{
		App app = new App();
		logger.info("App did stuff: " + app.doStuff());
	}

	public int doStuff() {
		int sum = 0;
		if (true) {
		    for (int i = 0; i < 5; i++) {
			sum += i;
		    }
		}
		return sum;
	}

}
