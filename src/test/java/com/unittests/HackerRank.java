package com.unittests;

import java.util.Scanner;

public class HackerRank {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int result=0;
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
          for(int i=1;i<=N;i++)
          {
        	  result=N * i;
        	  System.out.println(N +"*"+ "="+result);
            
          }
        scanner.close();
    }
}



