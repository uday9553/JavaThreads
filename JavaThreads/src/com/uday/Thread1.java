package com.uday;

public class Thread1 extends Thread {

	public void run() {
		System.out.println("Hello From Thread1"+currentThread().getName());
		
		try{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("some Thread Interupted Thread1");
		}
		System.out.println("Thread1 woke after 2 sec");
	}
}
