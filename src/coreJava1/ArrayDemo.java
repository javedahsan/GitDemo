package coreJava1;

public class ArrayDemo {
    

    		public static void passByreference(String a[]) {
    			a[0] = "Changed";
    }
    		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] b = {"Apple", "Peer", "Orange"};
		System.out.println(b[0]);
		ArrayDemo.passByreference(b);
		// apply change by pass by reference
		System.out.println(b[0]);
		
		
	}

}
