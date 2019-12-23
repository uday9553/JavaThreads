package com.uday;

import java.util.concurrent.Semaphore;

class ConsumeMessage extends Thread{
	int id;
	Semaphore semaphore;
	public ConsumeMessage(int id,Semaphore semaphore) {
		this.id=id;
		this.semaphore=semaphore;
	}
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("consuming message "+ id);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaphore.release();
		}
	}
}
public class SemaphoreExample {
	
	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(2);
		new ConsumeMessage(1, semaphore).start();
		new ConsumeMessage(2, semaphore).start();
		new ConsumeMessage(3, semaphore).start();
		new ConsumeMessage(4, semaphore).start();
		new ConsumeMessage(5, semaphore).start();
	}

}
