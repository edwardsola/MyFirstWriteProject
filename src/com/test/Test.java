package com.test;


public class Test {
	public static void main(String[] args) {
		String a="012";
		String b="";
		for(int i=0;i<a.length();i++){
			b=a.substring(i,i+1);
			System.out.println(Integer.valueOf(b));
		}
	}
}
