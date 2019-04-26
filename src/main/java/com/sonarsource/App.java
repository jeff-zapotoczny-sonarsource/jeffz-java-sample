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
    	logger.info("Hello World!");
        App app = new App();
        app.doStuff();
    }
    
    public int doStuff() {
    	int sum = 0;
    	for (int i = 0; i < 5; i++) {
    		sum += i;
    	}
    	return sum;
    }
   
}
