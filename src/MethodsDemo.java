
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodsDemo d = new MethodsDemo();
		d.getData();
		String name = d.getData2();
		System.out.println(name);
		
		MethodDemo2 d1 = new MethodDemo2();
		d1.getUserData();
		
		String x = getData3();
		
	}
	
	public void getData() {
		System.out.println("Hello World1");
	}
	
	public String getData2() {
		System.out.println("Hello World2");
		return "Rahul Shetty Academy";
		
	}
	
	// when we mark static to method within class- it can call without object within class
	public static String getData3() {
		System.out.println("Hello World4");
		return "Rahul Shetty Academy";
		
	}
	
} // end of class
