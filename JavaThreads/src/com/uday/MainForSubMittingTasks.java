package com.uday;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainForSubMittingTasks {
	private  TaskThreadPool taskThreadPool=new TaskThreadPool();

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainForSubMittingTasks tasks=new MainForSubMittingTasks();
		tasks.doSomething();

	}
	public void doSomething() {
		for(int i=0;i<7;i++) {
			Task task=new Task(i);
			final Future<?> taskResult=taskThreadPool.submit(task);
			System.out.println("task submitted "+task.i);
			ScheduledExecutorService executorService=Executors.newSingleThreadScheduledExecutor();
			executorService.schedule(new Runnable() {

				@Override
				public void run() {
					taskResult.cancel(true);
					
				}
				
			}, 3, TimeUnit.SECONDS);
		}
	}

}
