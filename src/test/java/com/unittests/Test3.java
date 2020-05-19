package com.unittests;

import org.testng.annotations.Test;

public class Test3 extends Test2{
	static int count=0;
	Test3(){
		
		count++;
	}
	
	@Test
	public void b() {
		super.a();
		System.out.println(count);
	}
		

	

}
