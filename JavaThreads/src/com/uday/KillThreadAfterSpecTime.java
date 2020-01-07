package com.uday;

public class KillThreadAfterSpecTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunningThread t1 = new RunningThread("First  thread"); 
		RunningThread t2 = new RunningThread("Second thread"); 
        try { 
            Thread.sleep(1000); 
            t1.stop(); // stopping thread t1 
            t2.stop(); // stopping thread t2 
            Thread.sleep(500); 
        } 
        catch (InterruptedException e) { 
            System.out.println("Caught:" + e); 
        } 
        System.out.println("Exiting the main Thread"); 
	}

}

class RunningThread implements Runnable { 
	  
    // to stop the thread 
    private boolean exit; 
  
    private String name; 
    Thread t; 
  
    RunningThread(String threadname) 
    { 
        name = threadname; 
        t = new Thread(this, name); 
        System.out.println("New thread: " + t); 
        exit = false; 
        t.start(); // Starting the thread 
    } 
  
    // execution of thread starts from run() method 
    public void run() 
    { 
        int i = 0; 
        while (!exit) { 
            System.out.println(name + ": " + i); 
            i++; 
            try { 
                Thread.sleep(100); 
            } 
            catch (InterruptedException e) { 
                System.out.println("Caught:" + e); 
            } 
        } 
        System.out.println(name + " Stopped."); 
    } 
  
    // for stopping the thread 
    public void stop() 
    { 
        exit = true; 
    } 
}
