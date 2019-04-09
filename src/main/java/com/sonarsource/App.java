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
    	while(true) {
    		System.out.println("I did stuff");
    	}
    }
    
}
