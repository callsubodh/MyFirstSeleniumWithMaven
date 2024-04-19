package ArrayDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		
		
	//limitation of array is the user needs to know the size of an array beforehand	
		int j=0;
		
		ArrayList obj = new ArrayList();
		obj.add(0, "Subodh");
		obj.add(1, "Koka");
		obj.add(243434.23);
		obj.add(8);
		
		System.out.println("ArrayList values: "+ obj);
		
		int noOfStudents = obj.size();
		System.out.println("Array size is: "+noOfStudents);
		
		for (int i=0; i<noOfStudents;i++) {
			
			System.out.println("Regular for loop details.."+obj.get(i));
		}
		
		//Enhanced for loop
		for(Object no:obj) {
			
			System.out.println("Enhanced for loop "+no);
			System.out.println("Enhanced for loop with toString "+no.toString());
		}
		
		while(j<noOfStudents) {
			System.out.println("No. of while students.."+obj.get(j));			
			j++;
	}
		
		Iterator itr = obj.iterator();
				
			while(itr.hasNext()) {				
				Object value = itr.next();
				System.out.println("Iterator value is: "+value);
			}
}
	

}
