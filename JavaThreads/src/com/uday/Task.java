package com.uday;

public class Task implements Runnable{
	int i;
	public Task(int i) {
		this.i=i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(i==this.i) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("working "+ i);
				break;
			}
		}
		
	}

	

}
