package com.uday;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello from MainClass");
		Thread1 t1=new Thread1();
		t1.start();
		System.out.println("Hello from MainClass1");
		Thread2 t2=new Thread2();
		t2.start();
		Thread3 t3=new Thread3();
		t1.interrupt();
		Thread tt3=new Thread(t3);
		tt3.start();
		
		
	}

}
