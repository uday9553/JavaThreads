package com.uday;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintingBook implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int recordCount=330;
		int lessons=100;
		int pagesperlesson=(int)Math.ceil((double)recordCount/lessons);
		ExecutorService executor=Executors.newFixedThreadPool(2);
		CountDownLatch countdownlatch=new CountDownLatch(pagesperlesson);
		for(int i=1;i<=pagesperlesson;i++) {
			final int val=i;
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("printing pages"+val);
					countdownlatch.countDown();
				}
			});
		}
		executor.shutdown();
		try {
			countdownlatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("printing done !!");
		
	}
	
}
public class CountDownLatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintingBook pb=new PrintingBook();
		Thread t1=new Thread(pb);
		t1.start();

	}

}
