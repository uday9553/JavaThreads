package com.uday;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class First implements Runnable{

	CyclicBarrier cyclicBarrier;
	public First(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier=cyclicBarrier;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Running FirstClass ...");
		
	}
	
}
class Second implements Runnable{

	CyclicBarrier cyclicBarrier;
	public Second(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier=cyclicBarrier;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Running SecondClass ...");
		
	}
	
}
public class CyclicBarrierEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//here it will start two threads when they are  ready 
		CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
		First fs=new First(cyclicBarrier);
		Second ss=new Second(cyclicBarrier);
		Thread t1=new Thread(fs);
		Thread t2=new Thread(ss);
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

	}

}
