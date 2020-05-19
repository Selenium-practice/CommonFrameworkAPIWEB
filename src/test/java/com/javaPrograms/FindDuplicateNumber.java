package com.javaPrograms;

import java.util.Arrays;
import java.util.*;

public class FindDuplicateNumber {
	
	public static void main(String[] args) {
		Set<Integer> set=new HashSet<Integer>();
		int a[]={1,3,2,4,5,6,2,7,7,3,3,5,3,3};
		for (int i = 0; i < a.length-1; i++) {
			
		
			if(set.contains(a[i]));
			{
				System.out.println(a[i]);
			}
		
			{
				set.add(a[i]);
			}
		}
		
		
		
		
		
	}

}
