import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// or define directly if we knows values
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,122};
		// get multiple of 2 from array
		
		
		for (int i=0;i<arr2.length; i++) {
			// compare two number use ==
			if (arr2[i] % 2 == 0) {
			System.out.println(arr2[i]);
			}else {
				System.out.println(arr2[i] + " number is not multiple of 2");
			}
		}
		// check if array has multiple of 2
		System.out.println("Test break");
		// until loop with break
		for (int i=0;i<arr2.length; i++) {
			// compare two number use ==
			if (arr2[i] % 2 == 0) {
			System.out.println(arr2[i]);
			break;
			}else {
				System.out.println(arr2[i] + " number is not multiple of 2");
			}
		}
		
		// arraylist 
		
		ArrayList<String> a = new ArrayList<String>();
		// Create a object of class - objectt method
		a.add("rahul");
		a.add("shetty");
		a.add("academy");
		a.add("selenium");
		System.out.println(a.get(3));
		
		for (int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		
		System.out.println("****Enhanced Arraylist*****");
		// Arraylist
		for (String val:a) {
			System.out.println(val);
		}
		
		// check if item selenium is present or not
		
		System.out.println(a.contains("selenium"));
		
		
		// convert array into array using list
		

		String [] name = {"rahul", "shetty", "Selenium"};
		
		List<String> nameArrayList = Arrays.asList(name);
		System.out.println(nameArrayList.contains("Selenium"));
		
		
		
	}

}
