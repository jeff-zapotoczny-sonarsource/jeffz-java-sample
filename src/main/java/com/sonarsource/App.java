package com.sonarsource;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
    	try {
    		OutputStream stream = new FileOutputStream("foo.txt");
    		System.out.println("I opened a file");
    	} catch (FileNotFoundException fnfe) {
    		System.out.println(fnfe.getMessage());
    	}
    }
    
}
