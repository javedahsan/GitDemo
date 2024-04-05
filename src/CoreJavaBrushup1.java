
public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		//defined data type - premitive and non-premitive data type
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean mycard = true;

		System.out.println(myNum + " is the value stored in mynum variable" );
		System.out.println(website + " is the value stored in website variable" );
		
		// arrays - mutiple values stores in one variable
		
		int [] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		// or define directly if we knows values
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,122};
		
		System.out.println(arr2[2]);
		
		// for loop concept
		
		for (int i=0; i< arr.length; i++){
		 System.out.println(arr[i]);
		}
		
		System.out.println("Printing Array2");
		for (int i=0; i< arr2.length; i++){
		 System.out.println(arr2[i]);
		}
		
		
		// String Array 
		
		String [] name = {"rahul", "shetty", "Selenium"};
		for (int i=0; i< name.length; i++){
			 System.out.println(name[i]);
			}
		
		
		//enhanced for loop
		
		System.out.println("print enhanced loop");
		
		for (String s: name) {
			System.out.println(s);
		}
		
		}
	}


