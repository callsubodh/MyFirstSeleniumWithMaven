package ArrayDemo;

public class SingleArrayDemo {
	
	public static void main(String[] args) {
		
		
	//limitation of array is the user needs to know the size of an array beforehand	
		int j=0;
		int students[] = new int[5];
		students[0]=77;
		//the below one is called typecast. Generally we are down casting (double to int)
		students[1]=(int)88.0;
		students[2]=99;
		students[3]=66;
		students[4]=55;
		
		System.out.println("Student id of 2nd one is: "+ students[1]);
		
		int noOfStudents = students.length;
		System.out.println(noOfStudents);
		
		for (int i=0; i<noOfStudents;i++) {
			
			System.out.println("No. of students.."+students[i]);
		}
		
		//Enhanced for loop
		for(int no:students) {
			
			System.out.println("Enhanced for loop"+no);
		}
		
		while(j<noOfStudents) {
			System.out.println("No. of while students.."+students[j]);				
			j++;
	}
}
	

}
