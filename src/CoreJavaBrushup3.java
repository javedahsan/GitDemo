
public class CoreJavaBrushup3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// String is an object -that represent sequence of characters // String literal 
		//Java will check if this values is already exist in memoory or not - 
		//if it exist then java will keep one
		//How many you define String -		// 2. String as new memory allocated literal
		
		//1. it will not create S1 be same value
		String s = "Rahul Shetty Academy";
		String s1= "Rahul Shetty Academy";

		//2. new - this way it will create both objects s2 and s3
	    String s2 = new String("Welcome");
	    String s3 = new String("Welcome");
	   
	    String[] splittedString = s.split(" ");
	    System.out.println(splittedString[0]);
	    System.out.println(splittedString[1]);
	    System.out.println(splittedString[2]);
	    
	    
	    String[] splittedString2 = s.split("Shetty");
	    System.out.println(splittedString2[0]);
	    System.out.println(splittedString2[1].trim());
	    
	    for (int i=0;i<s.length();i++) {
	    	System.out.println(s.charAt(i));
	    }
	    
	    System.out.println("Print string in reverse order");
	    //print the string in reverse order
	    for (int i = s.length()-1;i>=0;i--) {
	    	System.out.println(s.charAt(i));
	    }
	    
	    
	
	}

}
