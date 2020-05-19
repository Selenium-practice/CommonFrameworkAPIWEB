package com.javaPrograms;

import java.util.*;

public class JavaEightOne {
	
	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		items.forEach((k,v)->System.out.println("Key is :" +k +" Value is :" +v));
		
		//In Java 8, you can loop a Map with forEach + lambda expression.
		
		items.forEach((k,v)->{
			if("C".equals(k))
			{
				System.out.println();
				System.out.println("*************************");
				System.out.println("The value of 'C' for key is : " +v);
			}
			
		});
		
		
		
	}
}
