package coreJava1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS4 {

	//access all method and class into another class
	
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me first");
	}
	
	public void doThis() {
		System.out.println("I am here");
		System.out.println("I am here");
		System.out.println("I am here");
	}
	
	@AfterMethod
	public void afterRun() {
		System.out.println("Run me last");
	}
}
