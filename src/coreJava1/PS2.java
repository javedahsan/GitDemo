package coreJava1;

public class PS2 extends PS3{
    
	int a;
	// constructor of the class
	public PS2(int a) {
		// TODO Auto-generated constructor stub
	    super(a); //parent class 3 constructor is executed
		this.a=a; // this a is from class ps2
	} 
	
	public int increament() {
		a=a+1;
		return a;
	}
	
	public int decreament() {
		a=a-1;
		return a;
	}
}
