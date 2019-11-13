package com.uday;

public class Thread2 extends Thread{
	public void run() {
		System.out.println("Hello From Thread2"+currentThread().getName());
		try{
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Thread Interupted");
		}
		System.out.println("Thread2 woke after 2 sec");
	}
}
