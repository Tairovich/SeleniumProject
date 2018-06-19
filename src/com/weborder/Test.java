package com.weborder;

import java.util.Random;

public class Test {

	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int rd = r.nextInt(2);
		
//		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//		StringBuilder sb = new StringBuilder();
//		Random random = new Random();
//		for (int i = 0; i < 7; i++) {
//		    char c = chars[random.nextInt(chars.length)];
//		    sb.append(c);
//		}
//		String output = sb.toString();
//		System.out.println(output);
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 5; i++) {
//			
//			int zip = r.nextInt(9);
//			sb.append(""+zip);
//			
//		}
//		System.out.println(sb.toString());
		
		
//		int rCard = r.nextInt(3)+1;
//		
//		System.out.println(rCard);
		
		
		String month = "";
		int m = r.nextInt(12)+1;
		if(m < 10) {
			month = "0"+m;
		}else {
			month =""+m;
			
		}
	
			System.out.println( month);
	
		
		
		
		
		
		
		
		
		
	}
}
