package coreJava1;

public class ArrayObject {

	public static void main(String[] args) {
		// Create a array of objects
		// create two object
		Account obj[] = new Account[2];
		obj[0]  = new Account();
	    obj[1] = new Account();
	    
		obj[0].setData(2,3);
		System.out.println("For Array Element 0");
		obj[0].showData();

		obj[1].setData(4, 5);
		System.out.println("For Array Element 1");
		obj[1].showData();

	}
}

	class Account {

		int a=0;
		int b=0;
		// set method

		public void setData(int c, int d) {
			a = c;
			b = d;
		}

		// show method
		public void showData() {
			System.out.println("Value of a " + a);
			System.out.println("Value of b " + b);
		}
	}

