package com.uday;

public class ThreadUnCaughtExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("In run method");
				int a=0,b=10,c=0;
				c=b/a;
				
			}
		});
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("unhandled exception occured "+t.getName()+
						"the error is "+ e.getMessage());
				
			}
		});
		thread.start();

	}

}
