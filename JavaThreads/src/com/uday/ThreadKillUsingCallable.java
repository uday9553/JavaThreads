package com.uday;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadKillUsingCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exe=Executors.newFixedThreadPool(2);
		Future<Integer> future=exe.submit(new MyTask1(10, 20));
		try {
			future.get(2, TimeUnit.SECONDS);
			System.out.println("got result ");
		}catch (InterruptedException |ExecutionException e) {
			// TODO: handle exception
		}catch(TimeoutException e) {
			System.out.println("Waited for long time  ");
			future.cancel(true);
			exe.shutdownNow();
		}
		

	}

}
class MyTask1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		return x+y;
	}
	int x,y;
	MyTask1(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	
}
