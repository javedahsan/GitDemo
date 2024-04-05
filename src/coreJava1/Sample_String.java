package coreJava1;

public class Sample_String {
	public static void main(String args[]) {

		String str_Sample = "This is Index of Example";
		// Character at position
		System.out.println("Index of character 'x': " + str_Sample.indexOf('x'));
		// Character at position after given index value
		System.out.println("Index of character 's' after 3 index: " + str_Sample.indexOf('i', 3));
		// Give index position for the given substring
		System.out.println("Index of substring 'is': " + str_Sample.indexOf("is"));
		// Give index position for the given substring and start index
		System.out.println("Index of substring 'is' form index:" + str_Sample.indexOf("is", 5));
	}
}
