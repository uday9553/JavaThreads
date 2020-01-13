package com.uday;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;


public class TaskThreadPool extends ThreadPoolExecutor implements ApplicationListener<ContextClosedEvent>,InitializingBean{
	
	public ScheduledExecutorService executorService;
	public TaskThreadPool(){
		super(2,5,0l,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory());
	}

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("shut down successfull"+Thread.currentThread().getName());
		this.shutdown();
		this.executorService.shutdownNow();
		
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		if (t == null && r instanceof Future<?>) {
			try {
				Object result = ((Future<?>) r).get();
				System.out.println("afterExecute() "+Thread.currentThread().getName());
			} catch (CancellationException cancellationException) {
				t = cancellationException;
			} catch (ExecutionException executionException) {
				t = executionException.getCause();
			} catch (InterruptedException interruptedException) {
				Thread.currentThread().interrupt(); // ignore/reset
			}
		}if(t!=null) {
			System.out.println("unknown exception occured"+t.getMessage()+"   "+t.getStackTrace());
		}
	}

	public ScheduledExecutorService getExecutorService() {
		return executorService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		this.executorService=Executors.newSingleThreadScheduledExecutor();
		System.out.println("thread initialized"+Thread.currentThread().getName());
		
	}

}
