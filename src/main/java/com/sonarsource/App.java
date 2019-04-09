package com.sonarsource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App app = new App();
        app.doStuff();
    }
    
    public void doStuff() {
    	for (int i = 0; i < 100; i++) {
    		System.out.println("I did stuff");
    	}
    }
    
    public void doEvenMoreStuff() {
    	while(true) { // infinite loop
    		System.out.println("loop never ends!");
    	}
    }
}
