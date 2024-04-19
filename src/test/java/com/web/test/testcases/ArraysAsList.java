package com.web.test.testcases;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		
		String arr[] = new String[] {"abc","bcd","def","fgh", "ccee","aabb"};
		
		List<String> lt = Arrays.asList(arr);		
		System.out.println("List order is: "+lt);
		
		Collections.sort(lt);
		System.out.println("Sort order is: "+lt);	
		
		Collections.reverse(lt);		
		System.out.println("Reverse Sort order is: "+lt);
		
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println("Reverse Sort order from Arrays is: "+Arrays.toString(arr));
	}

}
