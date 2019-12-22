package com.uday;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyMath{
	public static int add(int x,int y) {
		return x+y;
	}
}
class MyTask implements Callable<Integer>
{

	int x,y;
	MyTask(int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public Integer call() throws Exception {
		int result;
		result=MyMath.add(x,y);
		return result;
	}
	
}

public class CallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int x=10,y=20;
		ExecutorService exe=Executors.newFixedThreadPool(2);
		Future<Integer> future=exe.submit(new MyTask(x, y));
		while(!future.isDone()) ;
		//Waiting for future to complete
		int result=future.get();
		System.out.println("output is "+result);
	}
}
