package com.sonarsource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	protected static Logger logger = LogManager.getLogger();
	
    public static void main( String[] args )
    {
    	logger.info("Hello World!");
        App app = new App();
        app.doStuff();
    }
    
    public void doStuff() {
    	for (int i = 0; i < 100; i++) {
    		logger.info("I did stuff");
    	}
    }
    
}
