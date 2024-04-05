package coreJava1;

import java.util.ArrayList;

public class Test_ArrayList {

	public static void main(String[] args) {
		// ArrayList store the element dynamically

		ArrayList<String> arlTest = new ArrayList<String>();

		// Size of arrayList
		System.out.println("Size of ArrayList at creation: " + arlTest.size());

		// add
		arlTest.add("D");
		arlTest.add("E");
		arlTest.add("F");
		arlTest.add("G");

		// Recheck Size of arrayList
		System.out.println("Size of ArrayList at creation: " + arlTest.size());

		// Display all contents of ArrayList
		System.out.println("List of all elements: " + arlTest);
		
		//Remove some elements from the list
		  arlTest.remove("D");
		  System.out.println("See contents after removing one element: " + arlTest);
		
		  //Check if the list contains "K"
		  System.out.println(arlTest.contains("K"));
		//Check if the list contains "K"
		  System.out.println(arlTest.contains("G"));
		  
	}

}
