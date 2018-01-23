package MultiThreading.Example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Three threads execute in order T1,T2,T3
public class JoinExample {
	
	public static void main(String args[]) throws InterruptedException {
		Thread T1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
			    System.out.println("Thread "+Thread.currentThread().getName());
				
			}
		});
		
		Thread T2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
			    try {
					T1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Thread "+Thread.currentThread().getName());
			    

				
			}
		});
		
		Thread T3 = new Thread (new Runnable() {
			
			@Override
			public void run() {
			    
			    try {
					T2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Thread "+Thread.currentThread().getName());
				
			}
		});
		
		
		T1.start();
		//T1.join();This will also work
		T2.start();
		//T2.join();This will also work
		T3.start();
		//T3.join();This will also work
	}
}

