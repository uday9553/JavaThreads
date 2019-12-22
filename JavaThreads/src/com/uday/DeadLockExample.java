package com.uday;

class FirstClass extends Thread{
	Object a,b;
	FirstClass(Object a,Object b){
		this.a=a;
		this.b=b;
	}
	@Override
	public void run() {
		synchronized(b) {
			try {
				Thread.sleep(10);
			}catch (Exception e) {
				// TODO: handle exception
			}
			synchronized(a) {
				System.out.println("First class is done");
			}
		}
	}
}
class SecondClass extends Thread{
	Object a,b;
	SecondClass(Object a,Object b){
		this.a=a;
		this.b=b;
	}
	@Override
	public void run() {
		synchronized(a) {
			try {
				Thread.sleep(10);
			}catch (Exception e) {
			}
			synchronized(b) {
				System.out.println("Second class is done");
			}
		}
	}
}
public  class DeadLockExample {
	
	public static void main(String[] args) {
		Object a=new Object();
		Object b=new Object();
		FirstClass  fs=new FirstClass(a, b);
		SecondClass sc=new SecondClass(a, b);
		fs.start();
		sc.start();
		System.out.println("Main class is Done");
	}
	
}
