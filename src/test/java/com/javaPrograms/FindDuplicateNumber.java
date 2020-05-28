package com.javaPrograms;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.*;

public class FindDuplicateNumber {
	
	public static void main(String[] args) {
		int data[]={1,3,2,4,5,6,2,7,7,3,3,5,3,3};
		/*Set<Integer> set=new HashSet<Integer>();
		
		for (int i = 0; i < a.length-1; i++) {
			
		
			if(set.contains(a[i]));
			{
				System.out.println(a[i]);
			}
		
			{
				set.add(a[i]);
			}
		}
		
		
		
		
		
	}*/
		
		Map<Integer,Integer> allDups = new HashMap<Integer,Integer>();
		for (int i = 0; i < data.length -1 ; i++) {
			if(allDups.containsKey(data[i])) 
				allDups.put(data[i], allDups.get(data[i])+1);
			else
				allDups.put(data[i], 1);
		}
		//allDups.entrySet().stream().filter((k,v)->
		allDups.forEach((k,v)->{
			if(v>1)
				{
				System.out.println(k);};
				});
		/*for (Entry<Integer, Integer> eachEntry : allDups.entrySet()) {
			if(eachEntry.getValue() > 1) {
				System.out.println(eachEntry.getKey());*/
			}
		
		
	}


