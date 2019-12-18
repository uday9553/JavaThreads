package com.uday;

public class ThreadCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread newThread=new NewThread();
		newThread.start();
		newThread.setName("aaa");

	}
	private static class NewThread extends Thread{
		public void run() {
			System.out.println("Hello from Thread" +this.getName());
		}
	}

}
